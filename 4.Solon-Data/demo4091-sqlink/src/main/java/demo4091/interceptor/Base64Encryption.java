package demo4091.interceptor;

import org.noear.solon.data.sqlink.base.SqLinkConfig;
import org.noear.solon.data.sqlink.base.intercept.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class Base64Encryption extends Interceptor<String> {
    private static final Logger log = LoggerFactory.getLogger(Base64Encryption.class);

    @Override
    public String doIntercept(String value, SqLinkConfig config) {
        String encrypt = encrypt(value);
        log.info("触发加密，原始值为{}，加密后为{}",value,encrypt);
        return encrypt;
    }

    private String encrypt(String password) {
        // 加密逻辑
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}
