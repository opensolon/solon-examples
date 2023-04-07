package demo4035.model;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table("appx")
public class AppxModel {
    @Id("app_id")
    private int appId;
    private Integer agroupId;
    private String note;
    private String appKey;
    private Integer arIsExamine;

    public Integer getAgroupId() {
        return agroupId;
    }

    public Integer getAppId() {
        return appId;
    }

    public Integer getArIsExamine() {
        return arIsExamine;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getNote() {
        return note;
    }
}
