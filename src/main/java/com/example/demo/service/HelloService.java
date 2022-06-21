package com.example.demo.service;

import com.example.demo.aop.AspectConfig;
import com.example.demo.model.Hello;
import com.example.demo.repository.HelloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;
    private Logger log = LoggerFactory.getLogger(AspectConfig.class);

    public String getHelloWorld()
    {
        return "Hello World!";
    }

    public String findByLang(String lang)
    {
        return helloRepository.findByLang(lang).getWord();
    }

    public Hello saveHello(Hello hello)
    {
        return helloRepository.save(hello);
    }
}
