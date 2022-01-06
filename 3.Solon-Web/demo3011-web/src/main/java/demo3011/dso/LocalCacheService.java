package demo3011.dso;

import org.noear.solon.data.cache.CacheService;
import org.noear.weed.cache.LocalCache;

public class LocalCacheService implements CacheService {
    LocalCache cache;
    public LocalCacheService(){
        cache = new LocalCache();
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
