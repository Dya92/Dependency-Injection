package diana.springframework.controllers;

import diana.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//DO NOT DO
@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    @Autowired
    @Qualifier("getterGreetingService")
    //Qualifier on Setters can be used above the method or before the parameter
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
