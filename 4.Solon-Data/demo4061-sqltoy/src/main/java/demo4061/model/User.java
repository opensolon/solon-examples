package demo4061.model;

import org.sagacity.sqltoy.config.annotation.Column;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;

import java.io.Serializable;
import java.sql.Types;

/**
 * 用户表
 */
@Entity(tableName="T_USER")
public class User implements Serializable {
    @Id
    @Column(name = "USER_NAME",type = Types.VARCHAR)
    private String username;
    @Column(name = "GENDER",type = Types.TINYINT)
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
