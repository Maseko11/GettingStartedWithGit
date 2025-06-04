package com.example.archigrid.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LandingPage {
    @GetMapping
    public String getLandPage(){
        return "index";
    }
}
