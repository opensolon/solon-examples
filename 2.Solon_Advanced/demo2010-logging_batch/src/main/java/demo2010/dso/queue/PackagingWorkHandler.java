package demo2010.dso.queue;

import java.util.List;

/**
 * @author noear 2023/1/7 created
 */
public interface PackagingWorkHandler<Event> {
    void onEvents(List<Event> list) throws Exception;
}
