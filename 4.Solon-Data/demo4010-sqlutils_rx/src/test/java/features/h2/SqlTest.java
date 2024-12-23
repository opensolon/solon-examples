package features.h2;

import features.Appx;
import features.TestDo;
import org.junit.jupiter.api.Test;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.util.ResourceUtil;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.rx.r2dbc.RxSqlUtils;
import org.noear.solon.rx.r2dbc.SqlBuilder;
import org.noear.solon.test.SolonTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@SolonTest
public class SqlTest {
    @Inject("h2")
    RxSqlUtils sqlUtils;

    @Bean
    public void init() throws Exception {
        String sql = ResourceUtil.getResourceAsString("db.sql");

        for (String s1 : sql.split(";")) {
            if (s1.trim().length() > 10) {
                sqlUtils.sql(s1).update().block();
            }
        }
    }

    @Test
    public void select1() {
        Number tmp = sqlUtils.sql("select 1").queryValue(Number.class).block();
        System.out.println(tmp);
        assert "1".equals(tmp.toString());
    }

    @Test
    public void select2() {
        Integer tmp = sqlUtils.sql("select app_id from appx limit 2")
                .queryValue(Integer.class).block();
        System.out.println(tmp);
        assert 1 == tmp;

        List<Integer> tmpList = sqlUtils.sql("select app_id from appx limit 2")
                .queryValueList(Integer.class)
                .collectList().block();
        System.out.println(tmpList);
        assert tmpList.size() == 2;
    }

    @Test
    public void select2_2() {
        Integer tmp = sqlUtils.sql("select app_id from appx where app_id=? limit 2", 99999)
                .queryValue(Integer.class).blockOptional().orElse(null);
        System.out.println(tmp);
        assert tmp == null;

        List<Integer> tmpList = sqlUtils.sql("select app_id from appx where app_id=? limit 2", 99999)
                .queryValueList(Integer.class)
                .collectList().block();
        System.out.println(tmpList);
        assert Utils.isEmpty(tmpList);
    }

    @Test
    public void select3() {
        Map tmp = sqlUtils.sql("select * from appx limit 1").queryRow(Map.class).block();
        System.out.println(tmp);
        assert tmp.size() > 2;

        System.out.println(tmp);

        Appx tmp2 = sqlUtils.sql("select * from appx limit 1").queryRow(Appx.class).block();
        System.out.println(tmp2);
        assert tmp2.app_id > 0;

        List<Map> tmpList = sqlUtils.sql("select * from appx limit 2")
                .queryRowList(Map.class)
                .collectList().block();
        System.out.println(tmpList);
        assert tmpList.size() == 2;


        List<Appx> tmpList2 = sqlUtils.sql("select * from appx limit 2")
                .queryRowList(Appx.class)
                .collectList().block();
        System.out.println(tmpList2);
        assert tmpList2.size() == 2;
    }

    @Test
    public void insert1() {
        sqlUtils.sql("delete from test where id=?", 2).update().block();
        assert 1L == sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2)
                .update()
                .block();
    }

    @Test
    public void insert1_2() {
        sqlUtils.sql("delete from test where id=?", 2).update().block();

        TestDo testDo = new TestDo(2);
        assert 1L == sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)").update(testDo, (ps, d) -> {
            return ps.bind(0, d.id).bind(1, d.v1).bind(2, d.v2);
        }).block();
    }

    @Test
    public void insert2() {
        sqlUtils.sql("delete from test where id=?", 2).update().block();
        Number key = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2)
                .updateReturnKey(Number.class)
                .block();

        System.out.println(key);

        //sqlite 是自增值；//h2 是插入值
        assert 2L == key.longValue() || key.longValue() > 0L;
    }

    @Test
    public void insert2_2() {
        sqlUtils.sql("delete from test where id=?", 2).update().block();


        TestDo testDo = new TestDo(2);
        Number key = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)")
                .updateReturnKey(Number.class, testDo, (ps, d) -> {
                    return ps.bind(0, d.id).bind(1, d.v1).bind(2, d.v2);
                }).block();

        System.out.println(key);

        //sqlite 是自增值；//h2 是插入值
        assert 2L == key.longValue() || key.longValue() > 0L;
    }

    @Test
    public void insert3() {
        sqlUtils.sql("delete from test where id=?", 2).update().block();
        Number key = sqlUtils.sql("insert into test(id,v1,v2,v3) values(?,?,?,?)", 2, 2, null, null)
                .updateReturnKey(Number.class).block();

        System.out.println(key);

        //sqlite 是自增值；//h2 是插入值
        assert 2L == key.longValue() || key.longValue() > 0L;
    }

    @Test
    public void executeBatch() {
        List<Object[]> argsList = new ArrayList<>();
        argsList.add(new Object[]{1, 1, 1});
        argsList.add(new Object[]{2, 2, 2});
        argsList.add(new Object[]{3, 3, 3});
        argsList.add(new Object[]{4, 4, 4});
        argsList.add(new Object[]{5, 5, 5});

        sqlUtils.sql("delete from test").update().block();
        List<Long> rows = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)")
                .updateBatch(argsList)
                .collectList().block();

        System.out.println(rows);
        assert rows.size() == 5;
    }

    @Test
    public void executeBatch2() {
        List<TestDo> argsList = new ArrayList<>();
        argsList.add(new TestDo(1));
        argsList.add(new TestDo(2));
        argsList.add(new TestDo(3));
        argsList.add(new TestDo(4));
        argsList.add(new TestDo(5));

        sqlUtils.sql("delete from test").update().block();
        List<Long> rows = sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)")
                .updateBatch(argsList, (ps, d) -> {
                    return ps.bind(0, d.id).bind(1, d.v1).bind(2, d.v2);
                }).collectList().block();

        System.out.println(rows);
        assert rows.size() == 5;
    }

    @Test
    public void update() {
        sqlUtils.sql("delete from test where id=?", 2).update().block();
        assert 1 == sqlUtils.sql("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2).update().block();

        assert 1 == sqlUtils.sql("update test set v1=? where id=?", 22, 2).update().block();

        Object val = sqlUtils.sql("select v1 from test where id=?", 2).queryValue(Object.class).block();
        System.out.println(val);

        assert 22 == (int) val;
    }

    @Test
    public void update1() {
        sqlUtils.sql("delete from test where id=?", 2).update().block();
        assert 1L == sqlUtils.sql("insert into test(id,v1,v2,v3) values(?,?,?,?)", 2, 2, 2, "a").update().block();

        assert 1L == sqlUtils.sql("update test set v1=?,v2=?,v3=? where id=?", 22, null, null, 2).update().block();

        Object val = sqlUtils.sql("select v1 from test where id=?", 2).queryValue(Object.class).block();
        System.out.println(val);

        assert 22 == (int) val;
    }

    @Test
    public void update2() {
        SqlBuilder sqlSpec = new SqlBuilder();
        sqlSpec.append("delete from test where id=?", 2);
        sqlUtils.sql(sqlSpec).update().block();

        sqlSpec.clear();
        sqlSpec.append("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2);
        assert 1 == sqlUtils.sql(sqlSpec).update().block();

        sqlSpec.clear();
        sqlSpec.append("update test set v1=? where id=?", 22, 2);
        assert 1 == sqlUtils.sql(sqlSpec).update().block();

        sqlSpec.clear();
        sqlSpec.append("select v1 from test where id=?", 2);
        Object val = sqlUtils.sql(sqlSpec).queryValue(Object.class).block();
        System.out.println(val);

        assert 22 == (int) val;
    }

    @Tran
    @Test
    public void update2_tran() {
        SqlBuilder sqlSpec = new SqlBuilder();
        sqlSpec.append("delete from test where id=?", 2);
        sqlUtils.sql(sqlSpec).update();

        sqlSpec.clear();
        sqlSpec.append("insert into test(id,v1,v2) values(?,?,?)", 2, 2, 2);
        assert 1 == sqlUtils.sql(sqlSpec).update().block();

        sqlSpec.clear();
        sqlSpec.append("update test set v1=? where id=?", 22, 2);
        assert 1 == sqlUtils.sql(sqlSpec).update().block();

        sqlSpec.clear();
        sqlSpec.append("select v1 from test where id=?", 2);
        Object val = sqlUtils.sql(sqlSpec).queryValue(Object.class).block();
        System.out.println(val);

        assert 22 == (int) val;
    }
}