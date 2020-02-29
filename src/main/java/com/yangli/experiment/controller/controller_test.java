package com.yangli.experiment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller_test {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHi(){
        return "Hi";
    }
    
}
