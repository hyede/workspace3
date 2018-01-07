package com.yede.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "suss";
    }

    @GetMapping("")
    public String test2() {
        return "suss2";
    }
}
