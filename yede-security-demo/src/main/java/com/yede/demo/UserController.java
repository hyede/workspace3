package com.yede.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yede on 2018/1/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{userId}")
    public String test(@PathVariable Long userId) {
        return "用户"+userId;
    }

    @GetMapping("")
    public String test2() {
        return "全部用户";
    }
}
