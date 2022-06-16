package com.example.demo.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getHelloWorld()
    {
        return "Hello World!";
    }
}
