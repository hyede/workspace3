package com.yede.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("/{testId}")
    public String test(@PathVariable Long testId) {
        return "testId"+testId;
    }

    @GetMapping("")
    public String test2() {
        return "测试所有的测试";
    }
}
