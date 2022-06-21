package com.example.demo.controller;


import com.example.demo.model.RequestExternalBody;
import com.example.demo.service.HelloService;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

@RestController
@RequestMapping
public class HelloController {

    @Value("${spring.profiles.active:Unknown}")
    private String activeProfile;
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

    @GetMapping(path = "hello/profiles")
    public String findByLangProfile(@RequestParam String lang) throws JsonProcessingException {
        if(Objects.equals(activeProfile, "db"))
        {
            return helloService.findByLang(lang);
        }
        else if(Objects.equals(activeProfile, "external"))
        {
            return externalHello(lang);
        }
        else
        {
            return "Hello World";
        }

    }

    @GetMapping(path = "secure/hello")
    public String secureHello() {
        return helloService.getHelloWorld();
    }

    //For the list of the available languages visit https://cloud.google.com/translate/docs/languages
    @GetMapping(path="external")
    public String externalHello(@RequestParam String lang) throws JsonProcessingException {
        RequestExternalBody body = new RequestExternalBody();
        body.setQ("Hello World");
        body.setTarget(lang);
        body.setFormat("text");

        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://translation.googleapis.com/language/translate/v2?key=AIzaSyDOg5AFknpTC8l9T_03kMgkEso8n5tW8VQ";

        HttpEntity<RequestExternalBody> entity = new HttpEntity<>(body);
        JsonNode response = restTemplate.exchange(uri, HttpMethod.POST, entity, JsonNode.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
        String data = response.path("data").toString();
        ArrayNode array = (ArrayNode) mapper.readTree(data).get("translations");
        String translated = "";
        if(array.isArray())
        {
            for(JsonNode jsonNode: array)
            {
                translated = jsonNode.get("translatedText").toString();
            }
        }
        return translated;
    }





}
