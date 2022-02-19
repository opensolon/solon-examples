package demoa001.model;

import org.noear.solon.validation.annotation.NotBlank;

public class Model {


    /**
     * 用户名
     * @since 1.0
     */
    @NotBlank
    String name;

    /**
     * nick name
     * @required
     * @since 1.0
     */
    String nick;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
