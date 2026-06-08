package demo3032.satoken;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.log.SaLog;
import cn.dev33.satoken.log.SaLogForConsole;
import cn.dev33.satoken.util.StrFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 将 Sa-Token log 信息转接到 Solon  
 * 
 * @author kong
 * @since 2022-11-2
 */
//@Managed
public class SaLogForSolon extends SaLogForConsole implements SaLog {
	static final Logger LOG = LoggerFactory.getLogger(SaLogForSolon.class);

	/**
	 * 打印日志到控制台
	 *
	 * @param level 日志等级
	 * @param str   字符串
	 * @param args  参数列表
	 */
	public void println(int level, String str, Object... args) {
		SaTokenConfig config = SaManager.getConfig();

		if (config.getIsLog() && level >= config.getLogLevelInt()) {
			switch (level) {
				case trace:
					LOG.trace(LOG_PREFIX + StrFormatter.format(str, args));
					break;
				case debug:
					LOG.debug(LOG_PREFIX + StrFormatter.format(str, args));
					break;
				case info:
					LOG.info(LOG_PREFIX + StrFormatter.format(str, args));
					break;
				case warn:
					LOG.warn(LOG_PREFIX + StrFormatter.format(str, args));
					break;
				case error:
				case fatal:
					LOG.error(LOG_PREFIX + StrFormatter.format(str, args));
					break;
			}
		}
	}
}
