<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solon SSE 实时任务演示</title>
    <!-- 引入我们更新后的CSS文件 -->
    <link rel="stylesheet" href="/index.css"/>
</head>
<body>

<div class="container">
    <h1>Solon SSE 实时任务演示</h1>
    <p>点击下方按钮，启动一个模拟的后台长耗时任务，并通过 Server-Sent Events (SSE) 实时接收任务进度。</p>

    <!-- 1. 触发任务的按钮 -->
    <button id="startButton">开始任务</button>

    <!-- 2. 进度条容器 (默认隐藏) -->
    <div id="progressContainer" class="progress-container">
        <div id="progressBar">0%</div>
    </div>

    <!-- 3. 日志显示区域 -->
    <div class="log-container">
        <pre id="log"></pre>
    </div>
</div>

<script>
    // 获取页面上的元素
    const startButton = document.getElementById('startButton');
    const logElement = document.getElementById('log');
    const progressContainer = document.getElementById('progressContainer');
    const progressBar = document.getElementById('progressBar');

    // 用于存储 EventSource 实例，方便后续关闭
    let eventSource = null;

    /**
     * 在日志区域打印消息的辅助函数
     * @param {string} message - 要打印的消息
     * @param {string} type - 消息类型 ('info', 'success', 'error', 'event')
     */
    function logMessage(message, type = 'info') {
        const timestamp = new Date().toLocaleTimeString();
        let prefix = '[INFO]';
        if (type === 'success') prefix = '[SUCCESS]';
        if (type === 'error') prefix = '[ERROR]';
        if (type === 'event') prefix = '[EVENT]';

        logElement.innerHTML += '<span>' + timestamp + ' ' + prefix + ': ' + message + '\n</span>';

        // 自动滚动到日志底部
        logElement.scrollTop = logElement.scrollHeight;
    }

    /**
     * 重置UI到初始状态
     */
    function resetUI() {
        startButton.disabled = false;
        startButton.textContent = '开始任务';
        progressContainer.style.visibility = 'hidden';
        progressBar.style.width = '0%';
        progressBar.textContent = '0%';
    }


    // 给“开始任务”按钮绑定点击事件
    startButton.addEventListener('click', async () => {
        // --- 准备阶段 ---
        logElement.innerHTML = ''; // 清空上次的日志
        logMessage('正在请求启动任务...');
        startButton.disabled = true;
        startButton.textContent = '任务执行中...';
        progressContainer.style.visibility = 'visible'; // 显示进度条

        try {
            // --- 步骤 1: 请求后端 /api/sse_demo/start 接口 ---
            const response = await fetch('/api/sse_demo/start');
            if (!response.ok) {
                throw new Error('服务器错误: ' + response.status);
            }
            const result = await response.json();

            if (result.code !== 200 || !result.data.taskId) {
                throw new Error('从服务器获取 taskId 失败: ' + (result.msg || '未知错误'));
            }

            const taskId = result.data.taskId;
            logMessage('任务已成功启动, 任务ID: ' + taskId);
            logMessage('准备建立 SSE 长连接...');

            // --- 步骤 2: 使用获取到的 taskId 创建 EventSource 连接 ---
            // EventSource 是浏览器原生支持 SSE 的对象
            eventSource = new EventSource('/api/sse_demo/connect/' + taskId);

            // --- 步骤 3: 监听 EventSource 的各种事件 ---

            // A. onopen: 当连接成功建立时触发
            eventSource.onopen = function () {
                logMessage('SSE 连接已成功建立！', 'success');
            };

            // B. onerror: 当连接发生错误时触发
            eventSource.onerror = function (err) {
                logMessage('SSE 连接发生错误，将自动关闭。请检查网络或后端服务。', 'error');
                console.error("EventSource failed:", err);
                eventSource.close(); // 出错时手动关闭连接
                resetUI();
            };

            // C. addEventListener: 监听从服务器发送的“命名事件”

            // 监听服务器发送的 "connected" 事件
            eventSource.addEventListener('connected', function (event) {
                logMessage('收到 [connected] 事件: ' + event.data, 'event');
            });

            // 监听服务器发送的 "progress" 事件 (核心)
            eventSource.addEventListener('progress', function (event) {
                const progressData = JSON.parse(event.data);
                const percentage = ((progressData.step / progressData.total) * 100).toFixed(0);

                // 更新进度条
                progressBar.style.width = percentage + '%';
                progressBar.textContent = percentage + '%';

                // 打印进度日志
                logMessage('收到 [progress] 事件: ' + progressData.message, 'event');
            });

            // 监听服务器发送的 "done" 事件
            eventSource.addEventListener('done', function (event) {
                logMessage('收到 [done] 事件: ' + event.data, 'success');
                logMessage('任务流程已结束，服务器将主动关闭连接。');
                // 服务器调用 complete() 后，浏览器会自动关闭连接，我们无需手动调用 eventSource.close()
                // 但为了确保UI状态正确，我们在这里重置UI
                setTimeout(resetUI, 1000); // 延迟1秒重置，让用户看到最终状态
            });

            // 监听服务器发送的 "task_error" 事件 (业务错误)
            eventSource.addEventListener('task_error', function (event) {
                logMessage('收到 [task_error] 事件: ' + event.data, 'error');
                logMessage('任务执行失败，连接已关闭。');
                eventSource.close();
                resetUI();
            });

            // 监听服务器发送的 "error" 事件 (严重错误)
            eventSource.addEventListener('error', function (event) {
                logMessage('收到 [error] 事件: ' + event.data, 'error');
                logMessage('任务执行失败，连接已关闭。');
                eventSource.close();
                resetUI();
            });

        } catch (error) {
            logMessage('操作失败: ' + error.message, 'error');
            resetUI();
        }
    });
</script>

</body>
</html>