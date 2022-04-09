package demo4071.model;

import lombok.Getter;
import lombok.Setter;
import net.hasor.db.mapping.Column;
import net.hasor.db.mapping.Table;

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
