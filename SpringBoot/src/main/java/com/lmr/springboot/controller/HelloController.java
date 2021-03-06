package com.lmr.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author lemonlimengran@didichuxing.com
 * @date 2019-10-16
 * @description
 */
@Slf4j
@Controller
@RequestMapping("/home")
public class HelloController {

    @RequestMapping("/index")
    public String hello(Model model) {
        log.info(DateFormat.getDateTimeInstance().format(new Date()));
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "index";
    }

}
