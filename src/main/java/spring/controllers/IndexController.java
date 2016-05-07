package spring.controllers;


import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping("/")
    String index(){
        return "index";
    }
}
