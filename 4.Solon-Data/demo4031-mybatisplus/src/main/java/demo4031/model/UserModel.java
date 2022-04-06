package demo4031.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author noear 2022/4/5 created
 */
@Setter
@Getter
@TableName("user")
public class UserModel {
    @TableId("id")
    Long id;
    Long userId;
    String nickname;
    String password;
//    @TableLogic
    Integer deleted;
}
