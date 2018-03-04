/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.app.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", "helloSpringBoot");
        model.addAttribute("list", Arrays.asList("hoge", "fuga", "piyo","hogehoge1121"));
        return "hello";
    }
}