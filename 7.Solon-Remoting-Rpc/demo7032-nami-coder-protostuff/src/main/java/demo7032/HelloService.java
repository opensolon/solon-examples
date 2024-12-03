package demo7032;

import org.noear.nami.annotation.NamiBody;

public interface HelloService {
    OrderDo hello(@NamiBody OrderDo order);
}