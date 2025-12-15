package com.microservices.springboot.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller -- make java class as Spring MVC controller
//@ResponseBody -- make java class as serialized JSON for HTTP ResponseBody

@RestController // combination of Controller and ResponseBody annotations
public class HelloWorldController {
    // HTTP GET Request
    @GetMapping("/hello-world")  // map http get request onto specific handler method
    public String helloWorld(){
        return "Hello, how are you?";
    }
}
