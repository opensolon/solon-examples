package demoa001.model;

import org.noear.solon.validation.annotation.NotBlank;
import org.noear.solon.validation.annotation.NotNull;

import java.io.Serializable;

public class Msg implements Serializable {
    /**
     * code 200 表示成功
     * @required
     * @since 1.0
     */
    @NotBlank
    private String code="200";
    /**
     * 请求是否成功true/false
     */
    @NotNull
    private boolean ok=true;
    /**
     * 请求相关数据
     */
    private Object data;
    /**
     * 请求结果描述，code!=200时应该返回此值
     * @since 1.0
     */
    private String msg;

    public Msg() {
    }

    public Msg(String code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Msg(String code, boolean ok, Object data, String msg) {
        this.code = code;
        this.ok = ok;
        this.data = data;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isOk() {
        return this.ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "Msg{code=" + this.code + ", ok=" + this.ok + ", data='" + this.data + '\'' + ", msg='" + this.msg + '\'' + '}';
    }

}
