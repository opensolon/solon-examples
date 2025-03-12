package features.h2;

import features.Appx;
import features.TestDo;
import org.junit.jupiter.api.Test;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Transaction;
import org.noear.solon.data.sql.*;
import org.noear.solon.data.sql.bound.RowIterator;
import org.noear.solon.test.SolonTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
@SolonTest
public class SqlTest {
    @Inject("h2")
    SqlUtils sqlUtils;

    @Bean
    public void init() throws Exception {
        sqlUtils.initDatabase("classpath:db.sql");
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
        Integer tmp = sqlUtils.sql("select app_id from appx where app_id=? limit 2", 99999)
                .queryValue();
        System.out.println(tmp);
        assert tmp == null;

        List<Integer> tmpList = sqlUtils.sql("select app_id from appx where app_id=? limit 2", 99999)
                .queryValueList();
        System.out.println(tmpList);
        assert tmpList == null;
    }

    @Test
    public void select3() throws SQLException {
        Map tmp = sqlUtils.sql("select * from appx limit 1").queryRow(Map.class);
        System.out.println(tmp);
        assert tmp.size() > 2;

        System.out.println(tmp);

        List<Appx> tmpList = sqlUtils.sql("select * from appx limit 2").queryRowList(Appx.class);
        System.out.println(tmpList);
        assert tmpList.size() == 2;
    }

    @Test
    public void select3_1() throws SQLException {
        Map tmp = sqlUtils.sql("select * from appx limit 1").queryRow(Map.class);
        System.out.println(tmp);
        assert tmp.size() > 2;

        System.out.println(tmp);

        Appx tmp2 = sqlUtils.sql("select * from appx limit 1").queryRow(Appx.class);
        System.out.println(tmp2);
        assert tmp2.app_id > 0;

        List<Map> tmpList = sqlUtils.sql("select * from appx limit 2").queryRowList(Map.class);
        System.out.println(tmpList);
        assert tmpList.size() == 2;


        List<Appx> tmpList2 = sqlUtils.sql("select * from appx limit 2").queryRowList(Appx.class);
        System.out.println(tmpList2);
        assert tmpList2.size() == 2;
    }

    @Test
    public void select3_2() throws SQLException {
        Map tmp = sqlUtils.sql("select * from appx where app_id=? limit 1", 99999)
                .queryRow(Map.class);
        System.out.println(tmp);
        assert tmp == null;

        List<Map> tmpList = sqlUtils.sql("select * from appx where app_id=? limit 2", 99999)
                .queryRowList(Map.class);
        System.out.println(tmpList);
        assert tmpList == null;
    }

    @Test
    public void select3_3() throws SQLException {
        Map tmp = sqlUtils.sql("select app_id appid from appx limit 1").queryRow(Map.class);
        System.out.println(tmp);
        assert tmp.size() == 1;

        assert tmp.get("appid") != null;
    }

    @Test
    public void select4() throws SQLException {
        RowIterator<Map> rowIterator = sqlUtils.sql("select * from appx limit ?", 100)
                .queryRowIterator(10, Map.class);
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
        assert 1 == sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2)
                .update();
    }

    @Test
    public void insert1_2() throws SQLException {
        TestDo testDo = new TestDo(2);

        sqlUtils.sql("delete from test where id=?", 2).update();
        assert 1 == sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)").params(testDo, (ps, d) -> {
            ps.setInt(1, d.id);
            ps.setInt(2, d.v1);
            ps.setInt(3, d.v2);
        }).update();
    }

    @Test
    public void insert2() throws SQLException {
        sqlUtils.sql("delete from test where id=?", 2).update();
        Number key = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)").params(2, 2, 2).updateReturnKey();

        System.out.println(key);

        //sqlite 是自增值；//h2 是插入值
        assert 2L == key.longValue() || key.longValue() > 0L;
    }

    @Test
    public void insert2_2() throws SQLException {
        TestDo testDo = new TestDo(2);

        sqlUtils.sql("delete from test where id=?").params(2).update();
        Number key = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)")
                .params(testDo, (ps, d) -> {
                    ps.setInt(1, d.id);
                    ps.setInt(2, d.v1);
                    ps.setInt(3, d.v2);
                }).updateReturnKey();

        System.out.println(key);

        //sqlite 是自增值；//h2 是插入值
        assert 2L == key.longValue() || key.longValue() > 0L;
    }

    @Test
    public void insert3() throws SQLException {
        sqlUtils.sql("delete from test where id=?")
                .params(2)
                .update();
        Number key = sqlUtils.sql("insert into test(id,v1,v2,v3) values(?,?,?,?)")
                .params(2, 2, null, null)
                .updateReturnKey();

        System.out.println(key);

        //sqlite 是自增值；//h2 是插入值
        assert 2L == key.longValue() || key.longValue() > 0L;
    }

    @Test
    public void insertBatch() throws SQLException {
        List<Object[]> argsList = new ArrayList<>();
        argsList.add(new Object[]{11, 1, 1});
        argsList.add(new Object[]{12, 2, 2});
        argsList.add(new Object[]{13, 3, 3});
        argsList.add(new Object[]{14, 4, 4});
        argsList.add(new Object[]{15, 5, 5});

        sqlUtils.sql("delete from test").update();
        List<Number> rows = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)")
                .params(argsList)
                .updateBatchReturnKeys();

        System.out.println(rows);
        assert rows.size() == 5;
        assert rows.get(0).intValue() == 11;
    }

    @Test
    public void insertBatch2() throws SQLException {
        List<TestDo> argsList = new ArrayList<>();
        argsList.add(new TestDo(1));
        argsList.add(new TestDo(2));
        argsList.add(new TestDo(3));
        argsList.add(new TestDo(4));
        argsList.add(new TestDo(5));

        sqlUtils.sql("delete from test").update();
        List<Number> rows = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)")
                .params(argsList, () -> (ps, d) -> {
                    ps.setInt(1, d.id);
                    ps.setInt(2, d.v1);
                    ps.setInt(3, d.v2);
                }).updateBatchReturnKeys();

        System.out.println(rows);
        assert rows.size() == 5;
        assert rows.get(0).intValue() == 1;
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
        int[] rows = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)")
                .params(argsList)
                .updateBatch();

        System.out.println(Arrays.toString(rows));
        assert rows.length == 5;
    }

    @Test
    public void executeBatch2() throws SQLException {
        List<TestDo> argsList = new ArrayList<>();
        argsList.add(new TestDo(1));
        argsList.add(new TestDo(2));
        argsList.add(new TestDo(3));
        argsList.add(new TestDo(4));
        argsList.add(new TestDo(5));

        sqlUtils.sql("delete from test").update();
        int[] rows = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)")
                .params(argsList, () -> (ps, d) -> {
                    ps.setInt(1, d.id);
                    ps.setInt(2, d.v1);
                    ps.setInt(3, d.v2);
                }).updateBatch();

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
    public void update1() throws SQLException {
        sqlUtils.sql("delete from test where id=?", 2).update();
        assert 1 == sqlUtils.sql("insert into test(id,v1,v2,v3) values(?,?,?,?)", 2, 2, 2, "a").update();

        assert 1 == sqlUtils.sql("update test set v1=?,v2=?,v3=? where id=?", 22, null, null, 2).update();

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

    @Transaction
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