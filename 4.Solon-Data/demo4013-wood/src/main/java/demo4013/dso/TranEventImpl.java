package demo4013.dso;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.event.EventListener;
import org.noear.solon.data.tran.TranEvent;

/**
 * @author noear 2023/8/28 created
 */
@Component
public class TranEventImpl implements EventListener<TranEvent> {
    @Override
    public void onEvent(TranEvent tranEvent) throws Throwable {
        System.out.println("----" + tranEvent.getPhase());
    }
}
