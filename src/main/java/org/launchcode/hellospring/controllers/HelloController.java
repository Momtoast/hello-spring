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
                "<select name='language'" +
                "<option value=''>Please choose a language</option>" +
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='German'>German</option>" +
                "<option value='Italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("English")) {
            greeting = "Hello";
        }
        else if (l.equals("French")) {
            greeting = "Bonjour";
        }
        else if (l.equals("Italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("Spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("German")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }
}
