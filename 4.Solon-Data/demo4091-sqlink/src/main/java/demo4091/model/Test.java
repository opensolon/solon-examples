package demo4091.model;

import lombok.Data;
import org.noear.solon.data.sqlink.annotation.*;


@Table("test")
@Data
public class Test {
    @Column(primaryKey = true)
    private Integer id;
    private Integer v1;
    @InsertDefaultValue(strategy = GenerateStrategy.Static, value = "101")
    private Integer v2;
}
