package demo4041.model;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import org.noear.solon.extend.activerecord.annotation.Table;

@Getter
@Setter
@Table(name = "appx", primaryKey = "app_id")
public class AppxModel extends Model<AppxModel> implements IBean {
    public int getAgroup_id() {
        return get("agroup_id");
    }

    public String getNote() {
        return get("note");
    }

    public String getApp_key() {
        return get("app_key");
    }

    public int getApp_id() {
        return get("app_id");
    }

    public int getAr_is_examine() {
        return get("ar_is_examine");
    }
}
