package demo4031.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("appx")
public class AppxModel {
    private Integer agroupId;
    private String note;
    private String appKey;
    @TableId("app_id")
    private Integer appId;
    private Integer arIsExamine;
}
