package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author victorzagnitko
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String homeController() {
        return "index";
    }

}
