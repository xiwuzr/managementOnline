package com.xiwu.server.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author ：wangjiahao
 * @date ：Created in
 * @description：
 */
@RestController
@RequestMapping("/employee")
public class HelloWorld {
    @GetMapping("basic/test1")
    public String hellow1(){
        return "success1";
    }
    @PostMapping("advanced/test2")
    public String hellow2(){
        return "success2";
    }
    @PutMapping("test")
    public String hellow3(){
        return "success3";
    }
}
