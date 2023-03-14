package demo2010.dso;

import org.noear.snack.ONode;
import org.noear.solon.logging.event.LogEvent;
import org.noear.solon.logging.persistent.PersistentAppenderBase;

import java.util.List;

/**
 * 持久化添加器（实现了异步、批量的特性）
 *
 * @author noear 2023/1/7 created
 */
public class PersistentAppender extends PersistentAppenderBase{
    @Override
    public void onEvents(List<LogEvent> list) {
        //批量插到数据库去（或者批量提义到远程接口）
        System.out.println(ONode.stringify(list));
    }
}
