package demo4034.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 类作用
 * @Author: csc
 * @Date: 2025/5/1 16:23
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserModel {

    private Integer id;

    private String name;
}
