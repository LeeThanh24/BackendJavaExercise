package com.ThanhLee.demoSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")

public class DemoController  {

    @GetMapping("")
    public String demo ()
    {
        return "hello /demo" ;
    }

    @GetMapping("/detail")
    public String demoDetail ()
    {
        return "hello /demo/detail" ;
    }
    @GetMapping("/hello")
    public String demoHello  ()
    {
        return "hello /demo/hello" ;
    }

}