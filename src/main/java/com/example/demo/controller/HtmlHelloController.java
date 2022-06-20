package com.example.demo.controller;

import com.example.demo.model.Hello;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HtmlHelloController {

    private final HelloService helloService;

    @Autowired
    public HtmlHelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    //Uncomment this to get /hello endpoint which returns a HTML page with ‘Hello World’ string displayed
//    @GetMapping(path = "hello")
//    @ResponseBody
//    public String helloAsHTML() {
//        return "<html>\n" + "<header>" +
//                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">" +
//                "<title>Hello World</title></header>\n" +
//                "<body>\n" + "<div class='fs-1 container h-100 d-flex justify-content-center align-items-center text-center text-uppercase'>Hello world</div>\n" + "</body>\n" + "</html>";
//    }

    @GetMapping(path = "admin")
    public String getAdminPage() {
        return "admin";
    }

    @PostMapping(path = "save")
    public String saveHello(
            @ModelAttribute Hello hello,
            Model model) {
        helloService.saveHello(hello);
        Long id = helloService.saveHello(hello).getId();
        String message = "Record with id : '" + id + "' is saved successfully !";
        model.addAttribute("message", message);
        return "admin";
    }

}
