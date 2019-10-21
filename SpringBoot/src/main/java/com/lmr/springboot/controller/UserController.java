package com.lmr.springboot.controller;

import com.lmr.springboot.pojo.entity.User;
import com.lmr.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lemonlimengran@didichuxing.com
 * @date 2019-10-21
 * @description
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public String getAllUser(Model model) {
        List<User> users = userService.queryAllUser();
        model.addAttribute("users", users);
        return "userInfo";
    }

}
