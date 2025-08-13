package demo4031.dso.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo4031.dso.mapper.AppxMapperPlus;
import demo4031.dso.mapper.AppxMapperPlusEx;
import demo4031.model.AppxModel;
import org.noear.solon.annotation.Managed;

/**
 * @author noear 2022/3/28 created
 */
@Managed
public class AppServicePlusImpl extends ServiceImpl<AppxMapperPlusEx, AppxModel> implements AppServicePlus {
}
