package demo9903.support;

import demo9903.server.ServarApp;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysInitUtil {
    public static void init() {
        // 1. Netty 相关设置
        System.setProperty("io.netty.tryReflectionSetAccessible", "true");
        System.setProperty("io.netty.noUnsafe", "false");

        // 2. JDK 内部访问设置
        System.setProperty("sun.misc.Unsafe.allowArrayHandleLeakage", "true");

        // 3. 禁用 Netty 的一些优化，避免使用 Unsafe
        // 如果上面的设置不起作用，可以尝试启用这些
        System.setProperty("io.netty.noKeySetOptimization", "true");
        System.setProperty("io.netty.recycler.maxCapacityPerThread", "0");

        // 4. 添加 JVM 参数的替代方案
        try {
            // 使用反射添加 --add-opens 等效果
            Class<?> moduleClass = Class.forName("java.lang.Module");
            java.lang.reflect.Method implAddExports = moduleClass.getDeclaredMethod("implAddExports", String.class, moduleClass);
            implAddExports.setAccessible(true);

            // 获取相关模块
            Object javaBaseModule = ModuleLayer.boot().findModule("java.base").get();

            // 获取当前类的模块（未命名模块）
            Object unnamed = ServarApp.class.getModule();

            // 正确导出关键包到未命名模块
            implAddExports.invoke(javaBaseModule, "jdk.internal.misc", unnamed);

            // 添加 opens 操作
            java.lang.reflect.Method implAddOpens = moduleClass.getDeclaredMethod("implAddOpens", String.class, moduleClass);
            implAddOpens.setAccessible(true);
            implAddOpens.invoke(javaBaseModule, "jdk.internal.misc", unnamed);
            implAddOpens.invoke(javaBaseModule, "sun.nio.ch", unnamed);
        } catch (Exception e) {
            // 打印详细错误，帮助诊断
            System.err.println("Warning: Unable to add module exports: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
