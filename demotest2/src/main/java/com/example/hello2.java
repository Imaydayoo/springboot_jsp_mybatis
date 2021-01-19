package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hello2 {
    @GetMapping("hello")
    public String hello(){
        return "1";
    }
}
