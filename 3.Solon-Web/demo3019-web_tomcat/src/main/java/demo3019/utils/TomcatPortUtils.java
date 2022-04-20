package demo3019.utils;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.Query;
import java.util.Iterator;
import java.util.Set;

/**
 * @author noear 2022/4/20 created
 */
public class TomcatPortUtils {
    public static int getHttpPort() {
        try {
            MBeanServer server;
            if (MBeanServerFactory.findMBeanServer(null).size() > 0) {
                server = MBeanServerFactory.findMBeanServer(null).get(0);
            } else {
                return -1;
            }

            Set names = server.queryNames(new ObjectName("Catalina:type=Connector,*"),
                    Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));

            Iterator iterator = names.iterator();
            if (iterator.hasNext()) {
                ObjectName name = (ObjectName) iterator.next();
                return Integer.parseInt(server.getAttribute(name, "port").toString());
            }
        } catch (Exception e) {
        }
        return -1;
    }
}
