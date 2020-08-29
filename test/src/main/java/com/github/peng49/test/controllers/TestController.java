package com.github.peng49.test.controllers;

import com.github.peng49.framework.web.mvc.Controller;
import com.github.peng49.framework.web.mvc.RequestMapping;
import com.github.peng49.framework.web.mvc.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hello")
    public String hello(@RequestParam("word") String word) {
        return "hello world!" + word;
    }
}
