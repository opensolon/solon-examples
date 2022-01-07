package apidemo3.controller;

import org.noear.solon.validation.annotation.Valid;

/**
 * 在基类，增加验证能力（进入网关的接口，不要自定义 Render；会被网关替代掉）
 *
 * @author noear 2021/6/11 created
 */
@Valid
public class ApiBase {
}
