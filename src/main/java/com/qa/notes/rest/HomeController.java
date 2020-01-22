package com.qa.notes.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class HomeController {

    @GetMapping(value = "/")
    public String getHomepage(){
        return "Hello world";
    }

}