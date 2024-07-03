package demo3011.dso;


import org.noear.solon.data.cache.CacheService;

import java.lang.reflect.Type;

public class NotCacheService implements CacheService {
    @Override
    public void store(String key, Object obj, int seconds) {
        System.out.println("定制成功了");
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public <T> T get(String key, Type type) {
        return null;
    }
}
