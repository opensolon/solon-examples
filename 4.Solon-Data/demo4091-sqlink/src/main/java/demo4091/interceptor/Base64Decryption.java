package demo4091.interceptor;

import org.noear.solon.data.sqlink.base.SqLinkConfig;
import org.noear.solon.data.sqlink.base.intercept.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class Base64Decryption extends Interceptor<String> {
    private static final Logger log = LoggerFactory.getLogger(Base64Decryption.class);

    @Override
    public String doIntercept(String value, SqLinkConfig config) {
        String decrypt = decrypt(value);
        log.info("触发解密，原始值为{}，解密后为{}",value,decrypt);
        return decrypt;
    }

    private String decrypt(String value) {
        // 解密逻辑
        return new String(Base64.getDecoder().decode(value));
    }
}
