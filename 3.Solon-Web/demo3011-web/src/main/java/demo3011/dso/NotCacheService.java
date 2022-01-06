package demo3011.dso;


import org.noear.solon.data.cache.CacheService;

public class NotCacheService implements CacheService {
    @Override
    public void store(String key, Object obj, int seconds) {
        System.out.println("定制成功了");
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void remove(String key) {

    }
}
