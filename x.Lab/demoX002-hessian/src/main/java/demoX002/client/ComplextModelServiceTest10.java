package demoX002.client;

import demoX002.client.dso.FairyConfigurationImp;
import org.noear.nami.NamiConfigurationDefault;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import demoX002.server.dso.IComplexModelService;
import demoX002.server.model.ComplexModel;
import demoX002.server.model.Person;
import demoX002.server.model.Point;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ComplextModelServiceTest10 {

    public static void main(String[] args) throws Exception {
        NamiConfigurationDefault.proxy = new FairyConfigurationImp();

        Solon.start(ComplextModelServiceTest10.class, args, app -> {
            app.enableHttp(false);
            app.enableWebSocket(false);
            app.enableSocketD(false);
        });


        ComplextModelServiceTest10 test5 = Solon.context().getBean(ComplextModelServiceTest10.class);
        test5.test();
    }

    @NamiClient
    IComplexModelService service;

    public void test() {
        ComplexModel<Point> model = new ComplexModel<Point>();
        model.setId(1);
        Person person = new Person();
        person.setName("Tom");
        person.setAge(86);
        person.setBirthDay(new Date());
        person.setSensitiveInformation("This should be private over the wire");
        model.setPerson(person);

        List<Point> points = new ArrayList<Point>();
        Point point = new Point();
        point.setX(3);
        point.setY(4);
        points.add(point);

        point = new Point();
        point.setX(100);
        point.setY(100);
        points.add(point);

        //远程方法调用
        model.setPoints(points);
        service.save(model);

        model = service.read(model.getId());
        List<Point> points1 = model.getPoints();
        for (Point elem : points1) {
            System.out.println(elem.getX() + "\t" + elem.getY());
        }
    }
}
