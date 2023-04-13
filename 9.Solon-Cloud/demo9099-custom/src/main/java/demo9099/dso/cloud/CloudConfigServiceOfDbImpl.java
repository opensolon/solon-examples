package demo9099.dso.cloud;

import org.noear.solon.cloud.CloudConfigHandler;
import org.noear.solon.cloud.exception.CloudConfigException;
import org.noear.solon.cloud.model.Config;
import org.noear.solon.cloud.service.CloudConfigObserverEntity;
import org.noear.solon.cloud.service.CloudConfigService;
import org.noear.wood.DbContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果有需要？可以根据业务需要增加缓存控制
 *
 * @author noear 2023/4/13 created
 */
public class CloudConfigServiceOfDbImpl implements CloudConfigService {
    DbContext db;

    public CloudConfigServiceOfDbImpl(DbContext db) {
        this.db = db;
    }

    @Override
    public Config pull(String group, String name) {
        try {
            return db.table("cloud_confg")
                    .whereEq("group", group)
                    .andEq("name", name)
                    .selectItem("*", Config.class);
        } catch (Exception e) {
            throw new CloudConfigException(e);
        }
    }

    @Override
    public boolean push(String group, String name, String value) {
        try {
            boolean isOk = db.table("cloud_confg")
                    .set("group", group)
                    .set("key", name)
                    .set("value", value)
                    .setInc("version", 1)//版本号加1
                    .upsertBy("group,key") > 0;

            //通知更新
            if (isOk) {
                notice(group, name);
            }

            return isOk;
        } catch (Exception e) {
            throw new CloudConfigException(e);
        }
    }

    @Override
    public boolean remove(String group, String name) {
        try {
            boolean isOk = db.table("cloud_confg")
                    .set("group", group)
                    .set("key", name)
                    .delete() > 0;

            if (isOk) {
                notice(group, name);
            }

            return isOk;
        } catch (Exception e) {
            throw new CloudConfigException(e);
        }
    }

    private Map<CloudConfigHandler, CloudConfigObserverEntity> observerMap = new HashMap<>();

    @Override
    public void attention(String group, String name, CloudConfigHandler observer) {
        if (observerMap.containsKey(observer)) {
            return;
        }

        CloudConfigObserverEntity entity = new CloudConfigObserverEntity(group, name, observer);
        observerMap.put(observer, entity);
    }

    /**
     * 通知更新
     */
    public void notice(String group, String name) {
        Config newCfg = pull(group, name);

        for (CloudConfigObserverEntity observer : observerMap.values()) {
            if (group.equals(observer.group) && name.equals(observer.key)) {
                observer.handle(newCfg);
            }
        }
    }
}
