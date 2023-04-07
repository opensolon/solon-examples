package demo4035.model;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author noear 2022/4/5 created
 */
@Setter
@Getter
@Table("user")
public class UserModel {
    @Id("id")
    Long id;
    Long userId;
    String nickname;
    String password;
    Integer deleted;
}
