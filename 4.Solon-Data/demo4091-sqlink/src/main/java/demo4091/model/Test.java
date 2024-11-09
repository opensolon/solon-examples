package demo4091.model;

import lombok.Data;
import org.noear.solon.data.sqlink.base.annotation.Column;
import org.noear.solon.data.sqlink.base.annotation.GenerateStrategy;
import org.noear.solon.data.sqlink.base.annotation.OnInsertDefaultValue;
import org.noear.solon.data.sqlink.base.annotation.Table;

@Table("test")
@Data
public class Test {
    @Column(primaryKey = true)
    private Integer id;
    private Integer v1;
    @OnInsertDefaultValue(strategy = GenerateStrategy.Static, value = "101")
    private Integer v2;
}
