package demo3031.controller;

import demo3031.dso.Session;
import demo3031.util.ImageUtils;
import demo3031.util.RandomUtils;
import org.noear.grit.client.GritClient;
import org.noear.grit.client.GritUtil;
import org.noear.grit.model.domain.Resource;
import org.noear.grit.model.domain.Subject;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.MethodType;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.core.handle.Result;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author noear 2021/6/1 created
 */
@Controller
public class LoginController extends BaseController {
    @Mapping("/")
    public void index(Context ctx) {
        ctx.forward("/login");
    }

    @Get
    @Mapping("/login") //视图 返回
    public ModelAndView login() {
        Session.current().clear();

        return view("login");
    }

    /**
     * 登录验证
     * */
    @Post
    @Mapping("/login/ajax/check")
    public Result login_ajax_check(String userName, String passWord, String captcha) throws Exception {

        //空内容检查
        if (Utils.isEmpty(captcha)) {
            return Result.failure("提示：请输入验证码！");
        }

        if (Utils.isEmpty(userName) || Utils.isEmpty(passWord)) {
            return Result.failure("提示：请输入账号和密码！");
        }

        String captchaOfSessoin = Session.current().getValidation();
        if (captcha.equalsIgnoreCase(captchaOfSessoin) == false) {
            return Result.failure("提示：验证码错误！");
        }

        Subject subject = GritClient.global().auth().login(userName, passWord);

        if (Subject.isEmpty(subject)) {
            //用户登录::失败
            return Result.failure("提示：账号或密码不对！");
        } else {
            //用户登录::成功
            Session.current().loadSubject(subject);
            Resource res = GritClient.global().auth().getUriFrist(subject.subject_id);

            if (Utils.isEmpty(res.link_uri)) {
                return Result.failure("提示：请联系管理员开通权限！");
            } else {
                String resUrl = GritUtil.buildDockUri(res);
                return Result.succeed(resUrl);
            }
        }
    }

    /*
     * 获取验证码图片
     */
    @Get
    @Mapping(value = "/login/validation/img", method = MethodType.GET, produces = "image/jpeg")
    public void getValidationImg(Context ctx) throws IOException {
        // 生成验证码存入session
        String validation = RandomUtils.code(4);
        Session.current().setValidation(validation);
        ctx.sessionState().sessionPublish();

        // 获取图片
        BufferedImage bufferedImage = ImageUtils.getValidationImage(validation);

        // 禁止图像缓存
        ctx.headerSet("Pragma", "no-cache");
        ctx.headerSet("Cache-Control", "no-cache");
        ctx.headerSet("Expires", "0");

        // 图像输出
        ImageIO.setUseCache(false);
        ImageIO.write(bufferedImage, "jpeg", ctx.outputStream());
    }
}
