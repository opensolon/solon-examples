package demo2010.dso.queue;

import java.util.Collection;

/**
 * 打包队列（一个个添加；打包后批量处理）
 *
 * @author noear 2023/1/7 created
 */
public interface PackagingQueue<Event> {
    /**
     * 设置工作处理
     * */
    void setWorkHandler(PackagingWorkHandler<Event> workHandler);
    /**
     * 设置空闲休息时间
     * */
    void setInterval(long interval);
    /**
     * 设置包装合大小
     * */
    void setPacketSize(int packetSize);

    /**
     * 添加
     * */
    void add(Event event);
    /**
     * 添加一批
     * */
    void addAll(Collection<Event> events);
}
