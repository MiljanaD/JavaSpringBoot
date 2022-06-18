package com.example.demo.service;

import com.example.demo.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public String getHelloWorld()
    {
        return "Hello World!";
    }

    public String findByLang(String lang)
    {
        return helloRepository.findByLang(lang).getWord();
    }
}
