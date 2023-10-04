package demo4082.test;

import demo4082.App;
import demo4082.model.User;
import org.hibernate.solon.annotation.Db;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.noear.solon.test.SolonJUnit5Extension;
import org.noear.solon.test.SolonTest;

import javax.persistence.EntityManagerFactory;

/**
 * @author noear 2023/10/4 created
 */
@ExtendWith(SolonJUnit5Extension.class)
@SolonTest(App.class)
public class JpaTest {
    @Db
    EntityManagerFactory factory;

    @Test
    public void test(){
        User user = new User();
        user.setUsername("test");
        user.setGender(1);
        factory.createEntityManager().persist(user);

        User user2 = factory.createEntityManager().find(User.class, "test");
        assert user2 != null;
        assert user.getUsername().equals(user2.getUsername());
    }
}
