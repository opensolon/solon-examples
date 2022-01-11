package demo4061.domain;

import org.sagacity.sqltoy.config.annotation.Column;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;

import java.io.Serializable;
import java.sql.Types;

/**
 * 字典表,仅做演示，逻辑可能不严谨
 */
@Entity(tableName="T_DICT")
public class Dictionary implements Serializable {
    @Id
    @Column(name = "SN",type = Types.VARCHAR)
    private String sn;
    @Column(name = "TITLE",type = Types.VARCHAR)
    private String title;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
