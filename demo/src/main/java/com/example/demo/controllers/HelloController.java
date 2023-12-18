package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    //Handles request of the form /hello?name=Demo
    // live /hello/hello
   @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST},value="hello")
    public String hello(@RequestParam String name, Model model)
   {
       String greeting = "Hello," + name + "!";
       model.addAttribute("greeting",greeting);
        return "hello";
    }
    //Handles request of the form /hello/Demo
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name,Model model){
       String greeting="Hello, " + name + "!";
       model.addAttribute("greeting",greeting);
        return "hello";
    }
    //live /hello/form
    @GetMapping("form")
    public String helloForm(){
       return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
       List<String> names = new ArrayList<>();
       names.add("Launcher");
       names.add("Java");
       names.add("JavaScript");
       model.addAttribute("names",names);
       return "hello-list";

    }
}

