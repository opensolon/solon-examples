package demo4082.test;

import demo4082.App;
import demo4082.model.User;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.solon.data.annotation.Tran;
import org.noear.solon.test.SolonJUnit5Extension;
import org.noear.solon.test.SolonTest;
import org.noear.wood.annotation.Db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * @author noear 2023/10/4 created
 */

@SolonTest(App.class)
public class JpaTest {
    @Db("db1")
    EntityManagerFactory factory;

    @Db
    SessionFactory sessionFactory;

    @Test
    @Tran // 必须开启，由于hibernate默认开启事务，必须添加@Tran，让solon进行管理
    public void test() throws InterruptedException {
        User user = new User();
        user.setUsername("test");
        user.setGender(1);
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.persist(user);

        User user2 = entityManager.find(User.class, "test");
        assert user2 != null;
        assert user.getUsername().equals(user2.getUsername());
        functionTest();  // 不会失效
//        threadTest(); // 事务会失效，异常不会回滚
        threadTest2(); // 事务会失效，异常不会回滚
//        threadTest3(entityManager); // 事务正常，手动触发回滚
    }

    /**
     * 函数测试
     */
    public void functionTest(){
        User user = new User();
        user.setUsername("functionTest");
        user.setGender(2);
        sessionFactory.getCurrentSession().save(user);
        //        int i = 1/0;
    }

    /**
     * 线程测试
     * 事务失效
     */
    public void threadTest() throws InterruptedException {
        Thread thread = new Thread(()->{
            User user = new User();
            user.setUsername("threadTest");
            user.setGender(3);
            sessionFactory.getCurrentSession().save(user);
            int i = 1/0;
        });
        thread.start();
        thread.join();
    }

    /**
     * 线程测试
     * 事务失效
     */
    @Tran
    public void threadTest2() throws InterruptedException {
        Thread thread = new Thread(()->{
            User user = new User();
            user.setUsername("threadTest2");
            user.setGender(3);
            sessionFactory.getCurrentSession().save(user);
            int i = 1/0;
        });
        thread.start();
        thread.join();
    }

    /**
     * 线程测试
     * 事务正常，手动触发回滚
     */
    @Tran
    public void threadTest3(EntityManager entityManager) throws InterruptedException {
        Thread thread = new Thread(()->{
            User user = new User();
            try {
                user.setUsername("threadTest3");
                user.setGender(3);
                entityManager.persist(user);
                int i = 1/0;
            } catch (Exception e){
                EntityTransaction entityTransaction = entityManager.getTransaction();
                entityTransaction.rollback();
            }
        });
        thread.start();
        thread.join();
    }

    /**
     *  使用对象管理器测试事务
     */
    @Tran
    @Test
    public void manageTest() {
        User user = new User();
        user.setUsername("test" + System.currentTimeMillis());
        user.setGender(1);
        factory.createEntityManager().persist(user);
//        int i = 1/0;
    }

    /**
     * 已读事务
     * @return {@link Object}
     */
    @Tran(readOnly = true)
    @Test
    public void readList() {
        List<User> list =   factory.createEntityManager()
                .createQuery("select e from user e", User.class)
                .getResultList();
        System.out.println(list);
    }

    /**
     * 使用默认session
     */
    @Test
    @Tran
    public void save(){
        User user = new User();
        user.setUsername("save");
        user.setGender(1);
        EntityManager session = sessionFactory.getCurrentSession();
        session.persist(user);
    }
}
