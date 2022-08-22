package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //@GetMapping("hello")
    //@ResponseBody
    //public String hello() {
     //   return "Hello, Spring!";
    //}

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String helloQueryParam(@RequestParam String name) {
        return "Hello, " + name +"!";
    }

    @GetMapping("{name}")
    public String helloPathParam(@PathVariable String name) {
        return "Hello, " + name +"!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>"+
                "<input type='submit' value='Greet Me'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
