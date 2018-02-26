package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello-world")
public class HelloWorldController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Greeting sayHello() {

        return new Greeting();
    }
}