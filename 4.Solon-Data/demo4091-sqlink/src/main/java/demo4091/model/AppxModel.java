package demo4091.model;

import lombok.Data;
import org.noear.solon.data.sqlink.annotation.*;


@Data
@Table("appx")
public class AppxModel {
    @Column("agroup_id")
    private int groupId;
    private String note;
    @Column("app_key")
    private String appKey;
    @Column("app_id")
    private int appId;
    @Column("ar_is_examine")
    private int isExamine;
}
