package demo4082.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户表
 */
@Entity(name = "user")
@Table(name="user")
public class User implements Serializable {
    @Id
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "GENDER")
    private Integer gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
