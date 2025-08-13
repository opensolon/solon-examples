package webapp.dso.module;

import net.hasor.dataql.DimUdf;
import net.hasor.dataql.DimUdfSource;
import net.hasor.dataql.Finder;
import net.hasor.dataql.QueryApiBinder;
import net.hasor.dataql.fx.db.FxSqlCheckChainSpi;
import net.hasor.dataway.dal.providers.db.InformationStorage;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.web.WebApiBinder;
import net.hasor.web.WebModule;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Inject;
import webapp.dso.spi.FxSqlCheckChain;

import javax.sql.DataSource;
import java.util.Objects;

@Managed
public class StartModule implements WebModule {
    @Inject("metadataDs")
    DataSource metadataDs;
    @Inject("dataDs1")
    DataSource dataDs1;
    @Inject("dataDs2")
    DataSource dataDs2;


    @Override
    public void loadModule(WebApiBinder apiBinder) throws Throwable {
        apiBinder.setEncodingCharacter("UTF-8", "UTF-8");
        //
        // .check dataSource
        Objects.requireNonNull(this.metadataDs, "metadataDs is null");
        Objects.requireNonNull(this.dataDs1, "dataDs1 is null");
        Objects.requireNonNull(this.dataDs2, "dataDs2 is null");
        //
        // .isolation meta-tables using InformationStorage
        apiBinder.bindType(InformationStorage.class).toInstance(() -> this.metadataDs);

        //
        // .add two data sources in to DataWay
        apiBinder.installModule(new JdbcModule(Level.Full, this.metadataDs));
        apiBinder.installModule(new JdbcModule(Level.Full, "ds1", this.dataDs1));
        apiBinder.installModule(new JdbcModule(Level.Full, "ds2", this.dataDs2));

        // 打印sql日志
        apiBinder.bindSpiListener(FxSqlCheckChainSpi.class, FxSqlCheckChain.getInstance());
        // 数据权限参数
        //apiBinder.bindSpiListener(PreExecuteChainSpi.class, PreExecuteChain.getInstance());

        //
        // udf/udfSource/import 指令 的类型创建委托给 spring
        QueryApiBinder queryBinder = apiBinder.tryCast(QueryApiBinder.class);
        queryBinder.bindFinder(Finder.TYPE_SUPPLIER.apply(Solon.cfg()::toBean));
        queryBinder.loadUdf(queryBinder.findClass(DimUdf.class));
        queryBinder.loadUdfSource(queryBinder.findClass(DimUdfSource.class));
    }
}
