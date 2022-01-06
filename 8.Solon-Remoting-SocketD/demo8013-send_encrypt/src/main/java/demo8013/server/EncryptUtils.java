package demo8013.server;

import org.noear.solon.Utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class EncryptUtils {

    //
    // aesEncrypt , aesDecrypt
    //
    public static byte[] aesEncrypt(byte[] content, String password) {
        return aesEncrypt(content, password, null);
    }

    public static byte[] aesEncrypt(byte[] content, String password, String algorithm) {
        return aesEncrypt(content, password, algorithm, null);
    }

    public static byte[] aesEncrypt(byte[] content, String password, String algorithm, String offset) {
        return aesEncrypt(content, password, algorithm, offset, null);
    }

    public static byte[] aesEncrypt(byte[] content, String password, String algorithm, String offset, String charset) {
        try {
            if (Utils.isEmpty(algorithm)) {
                algorithm = "AES/ECB/PKCS5Padding";
            }

            if (Utils.isEmpty(charset)) {
                charset = "UTF-8";
            }

            byte[] pswd = password.getBytes(charset);
            SecretKeySpec secretKey = new SecretKeySpec(pswd, "AES");
            Cipher cipher = Cipher.getInstance(algorithm);
            if (Utils.isEmpty(offset)) {
                cipher.init(1, secretKey);
            } else {
                IvParameterSpec iv = new IvParameterSpec(offset.getBytes(charset));
                cipher.init(2, secretKey, iv);
            }

            return cipher.doFinal(content);
        } catch (Exception var8) {
            var8.printStackTrace();
            return null;
        }
    }

    public static byte[] aesDecrypt(byte[] content, String password) {
        return aesDecrypt(content, password, null);
    }

    public static byte[] aesDecrypt(byte[] content, String password, String algorithm) {
        return aesDecrypt(content, password, algorithm, null);
    }

    public static byte[] aesDecrypt(byte[] content, String password, String algorithm, String offset) {
        return aesDecrypt(content, password, algorithm, offset, null);
    }

    public static byte[] aesDecrypt(byte[] content, String password, String algorithm, String offset, String charset) {
        try {
            if (Utils.isEmpty(algorithm)) {
                algorithm = "AES/ECB/PKCS5Padding";
            }

            if (Utils.isEmpty(charset)) {
                charset = "UTF-8";
            }

            byte[] pswd = password.getBytes(charset);
            SecretKey secretKey = new SecretKeySpec(pswd, "AES");

            //密码
            Cipher cipher = Cipher.getInstance(algorithm);
            if (Utils.isEmpty(offset)) {
                cipher.init(2, secretKey);
            } else {
                IvParameterSpec iv = new IvParameterSpec(offset.getBytes(charset));
                cipher.init(2, secretKey, iv);
            }

            return cipher.doFinal(content);
        } catch (Exception var9) {
            var9.printStackTrace();
            return null;
        }
    }
}
