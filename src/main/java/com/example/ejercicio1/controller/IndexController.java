package com.example.ejercicio1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class IndexController {

    @GetMapping(path = {"/","","/index"})
        public String index(Model m){
            m.addAttribute("mensa", "Este mensaje viene del controlador");
        return "index";
    }

   
}
