package demo3011.dso;

import org.noear.solon.data.cache.CacheService;
import org.noear.wood.cache.LocalCache;

public class LocalCacheService implements CacheService {
    LocalCache cache;

    public LocalCacheService() {
        cache = new LocalCache();
    }

    @Override
    public void store(String key, Object obj, int seconds) {
        cache.store(key, obj, seconds);
    }


    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public <T> T get(String key, Class<T> clz) {
        return cache.get(key, clz);
    }
}
