package com.fsd.fsdredislock.controller;

import com.fsd.fsdredislock.config.Lock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by lilei
 * since 2019/8/17
 **/
@RestController
@RequestMapping(value = "/redis")
public class TestController {
    @GetMapping(value = "/lock")
    @Lock(key="xxx")
    public String test() {

        return "ok";
    }
}
