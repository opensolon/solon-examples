package demo4091.model;

import demo4091.interceptor.Base64Decryption;
import demo4091.interceptor.Base64Encryption;
import lombok.Data;
import org.noear.solon.data.sqlink.annotation.*;

@Data
@Table("user")
public class User {
    @Column(primaryKey = true)
    @InsertDefaultValue(strategy = GenerateStrategy.DataBase)
    private int id;
    private String username;
    @OnPut(Base64Encryption.class)
    @OnGet(Base64Decryption.class)
    private String password;
}
