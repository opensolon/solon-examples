package demo7031;

import org.noear.nami.annotation.NamiBody;

public interface HelloService {
    OrderDo hello(@NamiBody OrderDo order);
}