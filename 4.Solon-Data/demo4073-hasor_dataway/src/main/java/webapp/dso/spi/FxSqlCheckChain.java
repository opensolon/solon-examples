package webapp.dso.spi;

import lombok.extern.slf4j.Slf4j;
import net.hasor.dataql.fx.db.FxSqlCheckChainSpi;
import net.hasor.utils.StringUtils;

@Slf4j
/**
 * FxSqlCheckChainSpi，这里主要用来打印 sql
 * https://www.dataql.net/docs/dataway/spi/fxsqlcheckchainspi
 */
public class FxSqlCheckChain implements FxSqlCheckChainSpi {

    public static FxSqlCheckChain getInstance() {
        return new FxSqlCheckChain();
    }

    @Override
    public int doCheck(FxSqlInfo fxSqlInfo) throws Throwable {
        String sourceName = fxSqlInfo.getSourceName();
        if (StringUtils.isNotEmpty(sourceName)) {
            log.info("【dataway】dataSource ==>:{}", sourceName);
        }
        log.info("【dataway】sql ==>:{}", fxSqlInfo.getQueryString().trim());
        log.info("【dataway】params ==>: {}", fxSqlInfo.getQueryParams());
        // 如果存在后续，那么继续执行检查，否则使用 EXIT 常量控制退出后续的检查。
        return FxSqlCheckChainSpi.NEXT;
    }
}
