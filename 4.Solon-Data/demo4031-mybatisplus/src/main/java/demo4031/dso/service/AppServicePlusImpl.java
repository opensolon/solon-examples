package demo4031.dso.service;

import com.baomidou.mybatisplus.solon.service.impl.ServiceImpl;
import demo4031.dso.mapper.AppxMapperPlus;
import demo4031.dso.mapper.AppxMapperPlusEx;
import demo4031.model.AppxModel;
import org.noear.solon.annotation.Component;

/**
 * @author noear 2022/3/28 created
 */
@Component
public class AppServicePlusImpl extends ServiceImpl<AppxMapperPlusEx, AppxModel> implements AppServicePlus {
}
