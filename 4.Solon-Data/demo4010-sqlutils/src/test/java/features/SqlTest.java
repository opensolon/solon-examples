package features;

import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.sql.SqlUtils;
import org.noear.solon.test.SolonTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author noear 2024/10/1 created
 */
@SolonTest
public class SqlTest {
    @Inject
    DataSource dataSource;

    @Test
    public void select1() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        Object tmp = sqlUtils.selectValue("select 1");
        System.out.println(tmp);
        assert "1".equals(tmp.toString());
    }

    @Test
    public void select2() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        Object tmp = sqlUtils.selectValue("select app_id from appx limit 2");
        System.out.println(tmp);
        assert tmp instanceof Integer;

        List<Object> tmpList = sqlUtils.selectValueArray("select app_id from appx limit 2");
        System.out.println(tmpList);
        assert tmpList.size() == 2;
    }

    @Test
    public void select2_2() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        Object tmp = sqlUtils.selectValue("select app_id from appx where app_id=? limit 2", 99999);
        System.out.println(tmp);
        assert tmp == null;

        List<Object> tmpList = sqlUtils.selectValueArray("select app_id from appx where app_id=? limit 2", 99999);
        System.out.println(tmpList);
        assert tmpList == null;
    }

    @Test
    public void select3() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        Map<String, Object> tmp = sqlUtils.selectRow("select * from appx limit 1");
        System.out.println(tmp);
        assert tmp.size() > 2;

        List<Map<String, Object>> tmpList = sqlUtils.selectRowList("select * from appx limit 2");
        System.out.println(tmpList);
        assert tmpList.size() == 2;
    }

    @Test
    public void select3_2() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        Map<String, Object> tmp = sqlUtils.selectRow("select * from appx where app_id=? limit 1", 99999);
        System.out.println(tmp);
        assert tmp == null;

        List<Map<String, Object>> tmpList = sqlUtils.selectRowList("select * from appx where app_id=? limit 2", 99999);
        System.out.println(tmpList);
        assert tmpList == null;
    }

    @Test
    public void select4() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        Iterator<Map<String, Object>> tmp = sqlUtils.selectRowStream("select * from appx limit 100", 10);
        System.out.println(tmp);

        int cout = 0;
        try {
            while (tmp.hasNext()) {
                System.out.println(tmp.next());
                cout++;
                if (cout == 2) {
                    break;
                }
            }
        } finally {
            tmp.remove();
        }

        assert cout == 2;
    }

    @Test
    public void insert1() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        sqlUtils.execute("delete from test where id=?", 2);
        assert 1 == sqlUtils.insert("insert test(id,v1,v2) values(?,?,?)", 2, 2, 2);
    }

    @Test
    public void insert2() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        sqlUtils.execute("delete from test where id=?", 2);
        assert 2L == sqlUtils.insertReturnKey("insert test(id,v1,v2) values(?,?,?)", 2, 2, 2);
    }

    @Test
    public void executeBatch() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        List<Object[]> argsList = new ArrayList<>();
        argsList.add(new Object[]{1, 1, 1});
        argsList.add(new Object[]{2, 2, 2});
        argsList.add(new Object[]{3, 3, 3});
        argsList.add(new Object[]{4, 4, 4});
        argsList.add(new Object[]{5, 5, 5});

        sqlUtils.execute("delete from test");
        int[] rows = sqlUtils.executeBatch("insert test(id,v1,v2) values(?,?,?)", argsList);

        System.out.println(rows);
        assert rows.length == 5;
    }

    @Test
    public void update() throws SQLException {
        SqlUtils sqlUtils = SqlUtils.of(dataSource);

        sqlUtils.execute("delete from test where id=?", 2);
        assert 1 == sqlUtils.insert("insert test(id,v1,v2) values(?,?,?)", 2, 2, 2);

        assert 1 == sqlUtils.execute("update test set v1=? where id=?", 22, 2);

        Object val = sqlUtils.selectValue("select v1 from test where id=?", 2);
        System.out.println(val);

        assert 22 == (int)val;
    }
}
