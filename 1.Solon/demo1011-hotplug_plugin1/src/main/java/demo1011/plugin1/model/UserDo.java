package demo1011.plugin1.model;

import java.io.Serializable;

/**
 * @author noear 2024/6/29 created
 */
public class UserDo implements Serializable {
    private long userId;
    private String userName;

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
