package demo4072.model;

import lombok.Getter;
import lombok.Setter;
import net.hasor.dbvisitor.mapping.Column;
import net.hasor.dbvisitor.mapping.Table;

@Getter
@Setter
@Table("appx")
public class Appx {
    @Column(primary = true)
    private int app_id;
    private int agroup_id;
    private String note;
    private String app_key;
    private int ar_is_examine;
}
