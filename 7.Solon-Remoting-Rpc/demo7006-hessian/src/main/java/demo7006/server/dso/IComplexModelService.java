package demo7006.server.dso;

import org.noear.nami.annotation.NamiClient;
import demo7006.server.model.ComplexModel;

@NamiClient(name = "test", path = "/ComplexModelService/")
public interface IComplexModelService {
    //持久化
    void save(ComplexModel model);

    //读取
    ComplexModel read(Integer modelId);
}
