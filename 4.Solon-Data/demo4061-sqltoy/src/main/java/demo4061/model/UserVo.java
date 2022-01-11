package demo4061.model;

import org.sagacity.sqltoy.config.annotation.SqlToyEntity;
import org.sagacity.sqltoy.config.annotation.Translate;

@SqlToyEntity
public class UserVo extends User{

    //用注解翻译gender字段，也可以写到.sql.xml文件中
    @Translate(cacheName = "GENDER",keyField = "gender")
    private String genderName;

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}
