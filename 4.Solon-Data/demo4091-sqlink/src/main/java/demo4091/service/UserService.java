package demo4091.service;

import demo4091.model.User;
import org.noear.solon.annotation.Managed;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.sqlink.SqLink;

import java.util.List;

@Managed
public class UserService {

    @Inject
    SqLink link;

    public List<User> getAll() {
        return link.query(User.class).toList();
    }

    public long saveUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return link.insert(user).executeRows();
    }

    public long changePassById(int id, String pass) {
        return link.update(User.class)
                .where(u -> u.getId() == id)
                .set(u -> u.setPassword(pass))
                .executeRows();
    }
}
