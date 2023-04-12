package demo3025.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.validation.annotation.Logined;

/**
 * 如果没登录，会出错
 * 如果用户换电脑登录，也会出错（即，之前登录的电脑就不能用了）
 *
 * @author noear 2023/4/5 created
 */
@Logined //可以使用验证注解了，并且是基于sso的
@Controller
public class AdminController extends BaseController{

}
