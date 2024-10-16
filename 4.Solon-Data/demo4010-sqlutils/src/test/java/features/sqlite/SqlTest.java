package features.sqlite;

import features.Appx;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.data.sql.*;
import org.noear.solon.test.SolonTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@SolonTest
public class SqlTest {
    @Inject("sqlite")
    SqlUtils sqlUtils;

    @Bean
    public void init() throws Exception {
        String sql = ResourceUtil.getResourceAsString("db.sql");

        for (String s1 : sql.split(";")) {
            if(s1.trim().length() > 10) {
                sqlUtils.sql(s1).update();
            }
        }
    }

    @Test
    public void select1() throws SQLException {
        Number tmp = sqlUtils.sql("select 1").queryValue();
        System.out.println(tmp);
        assert "1".equals(tmp.toString());
    }

    @Test
    public void select2() throws SQLException {
        Integer tmp = sqlUtils.sql("select app_id from appx limit 2").queryValue();
        System.out.println(tmp);

        List<Integer> tmpList = sqlUtils.sql("select app_id from appx limit 2").queryValueList();
        System.out.println(tmpList);
        assert tmpList.size() == 2;
    }

    @Test
    public void select2_2() throws SQLException {
        Integer tmp = sqlUtils.sql("select app_id from appx where app_id=? limit 2", 99999).queryValue();
        System.out.println(tmp);
        assert tmp == null;

        List<Integer> tmpList = sqlUtils.sql("select app_id from appx where app_id=? limit 2", 99999).queryValueList();
        System.out.println(tmpList);
        assert tmpList == null;
    }

    @Test
    public void select3() throws SQLException {
        Row tmp = sqlUtils.sql("select * from appx limit 1").queryRow();
        System.out.println(tmp);
        assert tmp.size() > 2;

        System.out.println(tmp.data());
        System.out.println(tmp.toMap());

        Appx tmp2 = tmp.toBean(Appx.class);
        System.out.println(tmp2);
        assert tmp2.app_id > 0;

        RowList tmpList = sqlUtils.sql("select * from appx limit 2").queryRowList();
        System.out.println(tmpList);
        assert tmpList.size() == 2;


        List<Appx> tmpList2 = tmpList.toBeanList(Appx.class);
        System.out.println(tmpList2);
        assert tmpList2.size() == 2;
    }

    @Test
    public void select3_2() throws SQLException {
        Row tmp = sqlUtils.sql("select * from appx where app_id=? limit 1", 99999).queryRow();
        System.out.println(tmp);
        assert tmp == null;

        List<Row> tmpList = sqlUtils.sql("select * from appx where app_id=? limit 2", 99999).queryRowList();
        System.out.println(tmpList);
        assert tmpList == null;
    }

    @Test
    public void select4() throws SQLException {
        RowIterator rowIterator = sqlUtils.sql("select * from appx limit ?", 100).queryRowIterator(10);
        System.out.println(rowIterator);

        try (rowIterator) {
            while (rowIterator.hasNext()) {
                System.out.println(rowIterator.next());
                if (rowIterator.rownum() == 2) {
                    break;
                }
            }
        }

        assert rowIterator.rownum() == 2;
    }

    @Test
    public void insert1() throws SQLException {
        sqlUtils.sql("delete from test where id=?", 2).update();
        assert 1 == sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2).update();
    }

    @Test
    public void insert2() throws SQLException {
        sqlUtils.sql("delete from test where id=?", 2).update();
        Number key = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2).updateReturnKey();

        System.out.println(key);

        //sqlite 是自增值；//h2 是插入值
        assert 2L == key.longValue() || key.longValue() > 0L;
    }

    @Test
    public void executeBatch() throws SQLException {
        List<Object[]> argsList = new ArrayList<>();
        argsList.add(new Object[]{1, 1, 1});
        argsList.add(new Object[]{2, 2, 2});
        argsList.add(new Object[]{3, 3, 3});
        argsList.add(new Object[]{4, 4, 4});
        argsList.add(new Object[]{5, 5, 5});

        sqlUtils.sql("delete from test").update();
        int[] rows = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)").updateBatch(argsList);

        System.out.println(Arrays.toString(rows));
        assert rows.length == 5;
    }

    @Test
    public void update() throws SQLException {
        sqlUtils.sql("delete from test where id=?", 2).update();
        assert 1 == sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2).update();

        assert 1 == sqlUtils.sql("update test set v1=? where id=?", 22, 2).update();

        Object val = sqlUtils.sql("select v1 from test where id=?", 2).queryValue();
        System.out.println(val);

        assert 22 == (int) val;
    }

    @Test
    public void update2() throws SQLException {
        SqlBuilder sqlSpec = new SqlBuilder();
        sqlSpec.append("delete from test where id=?", 2);
        sqlUtils.sql(sqlSpec).update();

        sqlSpec.clear();
        sqlSpec.append("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2);
        assert 1 == sqlUtils.sql(sqlSpec).update();

        sqlSpec.clear();
        sqlSpec.append("update test set v1=? where id=?", 22, 2);
        assert 1 == sqlUtils.sql(sqlSpec).update();

        sqlSpec.clear();
        sqlSpec.append("select v1 from test where id=?", 2);
        Object val = sqlUtils.sql(sqlSpec).queryValue();
        System.out.println(val);

        assert 22 == (int) val;
    }

    @Tran
    @Test
    public void update2_tran() throws SQLException {
        SqlBuilder sqlSpec = new SqlBuilder();
        sqlSpec.append("delete from test where id=?", 2);
        sqlUtils.sql(sqlSpec).update();

        sqlSpec.clear();
        sqlSpec.append("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2);
        assert 1 == sqlUtils.sql(sqlSpec).update();

        sqlSpec.clear();
        sqlSpec.append("update test set v1=? where id=?", 22, 2);
        assert 1 == sqlUtils.sql(sqlSpec).update();

        sqlSpec.clear();
        sqlSpec.append("select v1 from test where id=?", 2);
        Object val = sqlUtils.sql(sqlSpec).queryValue();
        System.out.println(val);

        assert 22 == (int) val;
    }
}
