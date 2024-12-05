package demo7031;

import org.noear.nami.annotation.NamiBody;

public interface HelloService {
    MessageDo hello(@NamiBody MessageDo order);
}