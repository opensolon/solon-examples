package demo4091.model;

import lombok.Data;
import org.noear.solon.data.sqlink.base.annotation.Column;
import org.noear.solon.data.sqlink.base.annotation.Table;

@Table("test")
@Data
public class Test {
    @Column(primaryKey = true)
    private int id;
    private int v1;
    private int v2;
}
