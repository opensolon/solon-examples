package demo3011.dso;

import org.noear.solon.data.cache.CacheService;
import org.noear.weed.cache.memcached.MemCache;

import java.util.Properties;

public class MemCacheService implements CacheService {
    MemCache cache;
    public MemCacheService(Properties prop){
        cache = new MemCache(prop);
    }

    @Override
    public void store(String key, Object obj, int seconds) {
        cache.store(key,obj,seconds);
    }

    @Override
    public Object get(String key) {
        return cache.get(key);
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }
}
