package diana.springframework;

import diana.springframework.controllers.ConstructorInjectedController;
import diana.springframework.controllers.MyController;
import diana.springframework.controllers.PropertyInjectedController;
import diana.springframework.controllers.SetterInjectedController;
import diana.springframework.examplebeans.FakeDataSource;
import diana.springframework.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        //got a handle on the context
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        //asked the context to give me a bean with the name "myController" starting with lowercase
        MyController controller = (MyController) ctx.getBean("myController");

        //FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
        //casting unnecessary here
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUser());

        //FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
        //casting unnecessary here
        FakeJmsBroker fakeJmsBroker = ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUser());
    }

}
