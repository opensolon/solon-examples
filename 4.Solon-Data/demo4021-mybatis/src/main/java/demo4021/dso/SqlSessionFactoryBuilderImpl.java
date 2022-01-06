package demo4021.dso;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author noear 2021/10/20 created
 */
public class SqlSessionFactoryBuilderImpl extends SqlSessionFactoryBuilder {

    @Override
    public SqlSessionFactory build(Configuration config) {
        System.out.println("....进来了...");
        return super.build(config);
    }
}
