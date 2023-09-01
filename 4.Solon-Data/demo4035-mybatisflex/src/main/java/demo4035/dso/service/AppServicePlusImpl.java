package demo4035.dso.service;


import com.mybatisflex.solon.service.impl.ServiceImpl;
import demo4035.dso.mapper.AppxMapperPlusEx;
import demo4035.model.AppxModel;
import org.noear.solon.annotation.Component;

/**
 * @author noear 2022/3/28 created
 */
@Component
public class AppServicePlusImpl extends ServiceImpl<AppxMapperPlusEx, AppxModel> implements AppServicePlus {
}
