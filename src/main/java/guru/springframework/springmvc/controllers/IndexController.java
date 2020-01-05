package guru.springframework.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        //Thymeleaf auto cari index.html
        return "index";
    }
}