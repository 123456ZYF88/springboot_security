package com.aaa.sbs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2022/2/14 9:05
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    /**
     * 入门测试
     * @return
     * @return
     */
    @GetMapping("helloSpringSecurity")
    public  String hello(){
        return "hello Security";
    }
}
