package demo4037.entity;

import lombok.Data;
import org.noear.snack.core.utils.DateUtil;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "create_time")
    private Date createTime;

    @LogicDelete
    @Column(name = "is_del")
    private Boolean isDel;

    @Override
    public String toString() {

        return String.format("id:%d, name:%s, age:%d, createTime:%s", id, name, age,
                createTime != null ? DateUtil.format(createTime, DateUtil.FORMAT_19_b) : null);
    }
}