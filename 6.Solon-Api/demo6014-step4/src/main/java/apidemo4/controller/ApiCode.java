package apidemo4.controller;

import org.noear.solon.core.handle.Result;
import org.noear.solon.ext.DataThrowable;

/**
 * 接口状态码
 *
 * @author noear 2021/6/11 created
 */
public class ApiCode extends DataThrowable {
    private int code = 0;
    private String description = "";

    /**
     * 代码
     */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 描述
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApiCode(int code) {
        super(code + ""); //给异常系统用的
        this.code = code;
    }

    public ApiCode(int code, String description) {
        super(code + ": " + description);//给异常系统用的
        this.code = code;
        this.description = description;
    }

    public ApiCode(Throwable cause) {
        super(Result.FAILURE_CODE + ": " + cause.getMessage(), cause);
        this.description = cause.getMessage();
    }
}
