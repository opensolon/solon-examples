package demo4091.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.noear.solon.data.sqlink.base.annotation.Column;
import org.noear.solon.data.sqlink.base.annotation.Table;

@Data
@Table(schema = "INFORMATION_SCHEMA", value = "TABLES")
public class DbTable
{
    @Column("table_name")
    private String tableName;
}
