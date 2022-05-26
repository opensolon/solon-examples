package demo1011.common.event;

/**
 * @author noear 2022/5/26 created
 */
public class OrderCreatedEvent {
    private String name;

    public String getName() {
        return name;
    }

    public OrderCreatedEvent(String name){
        this.name = name;
    }
}
