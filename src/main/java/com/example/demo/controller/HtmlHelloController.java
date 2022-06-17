package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlHelloController {

    @GetMapping(path = "hello", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String helloAsHTML() {
        return "<html>\n" + "<header>" +
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">" +
                "<title>Hello World</title></header>\n" +
                "<body>\n" + "<div class='fs-1 container h-100 d-flex justify-content-center align-items-center text-center text-uppercase'>Hello world</div>\n" + "</body>\n" + "</html>";
    }
}
