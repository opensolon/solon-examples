package demo9906;

import org.noear.solon.Solon;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author noear 2021/1/8 created
 */
public class ServarApp {
    public static void main(String[] args) throws SQLException, IOException {
        Solon.start(ServarApp.class, args);
    }
}
