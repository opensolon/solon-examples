package demo7032;

import org.noear.nami.annotation.NamiBody;

public interface HelloService {
    MessageDo hello(@NamiBody MessageDo order);
}