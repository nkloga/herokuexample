package greeting.controller;

import greeting.instance.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * handles GET requests for /greeting by returning a new instance of the Greeting class
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //The annotation ensures that HTTP requests to /greeting are mapped to the greeting() method below
    @RequestMapping(method = GET, value = "/greet")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/api/foos")
    @ResponseBody
    public String getFoos(@RequestParam String id){
        return "ID: " + id;
    }
    @RequestMapping(method = GET, value = "/something")
    public String some(){
        return "Something 123";
    }

}
