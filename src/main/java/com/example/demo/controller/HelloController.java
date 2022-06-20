package com.example.demo.controller;

import com.example.demo.model.Hello;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping(path = "hello-rest")
    public String getHelloWorld() {
        return helloService.getHelloWorld();
    }

    @GetMapping(path = "hello")
    public String findByLang(@RequestParam String lang) {
        return helloService.findByLang(lang);
    }

    @GetMapping(path = "secure/hello")
    public String secureHello() {
        return helloService.getHelloWorld();
    }






}
