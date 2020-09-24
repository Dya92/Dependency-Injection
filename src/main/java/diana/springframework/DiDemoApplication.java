package diana.springframework;

import diana.springframework.controllers.ConstructorInjectedController;
import diana.springframework.controllers.MyController;
import diana.springframework.controllers.PropertyInjectedController;
import diana.springframework.controllers.SetterInjectedController;
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

        System.out.println(controller.hello());
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
    }

}
