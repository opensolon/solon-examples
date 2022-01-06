package demo3011.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserModel {
    public long id;
    public String name;
    public int sex;
    public String label;

    public transient String _type;

    public Date date = new Date();

    public long[] aaa;
}
