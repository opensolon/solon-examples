package demo4033.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("appx")
public class AppxModel {
    @TableId("app_id")
    private Integer appId;
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
