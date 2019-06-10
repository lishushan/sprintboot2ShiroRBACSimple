package com.jungle.springboot.security.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jungle
 * @version V1.0
 * @date 2019/5/28
 * 描述：登录控制器
 * copyright © 2019- .com
 */
@Controller
public class LoginController {

    /**
     * 功能描述：执行登录操作。
     *
     * @return object 输出数据
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public Object doLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            return "redirect:index";
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException | ExcessiveAttemptsException e) {
            return "redirect:login";
        }
    }

    /**
     * 跳转： 登录页面.
     *
     * @return Object
     */
    @RequestMapping(path = {"/login"}, method = RequestMethod.GET)
    public String login() {

        return "login";
    }
}
