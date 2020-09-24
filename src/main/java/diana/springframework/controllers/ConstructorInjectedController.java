package diana.springframework.controllers;

import diana.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//DO THIS
@Controller
public class ConstructorInjectedController {
    private GreetingService greetingService;

   // @Autowired - optional, it does it anyways
    // @Qualifier receives a string representing a class name starting with lowercase
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
