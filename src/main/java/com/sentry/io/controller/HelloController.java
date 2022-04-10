package com.sentry.io.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lidongqi1@xdf.cn
 * @Date: 2021/3/15 1:33 下午
 * @description: sentry test
 */

@RestController
@Slf4j
public class HelloController {

    @GetMapping(value = "/hello")
    public String sayHello() {
        log.error("我是一个异常，测试1");
        throw new RuntimeException("我是一个异常，测试2");
    }
}
