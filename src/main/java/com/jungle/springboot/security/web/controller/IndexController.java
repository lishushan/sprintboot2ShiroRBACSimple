package com.jungle.springboot.security.web.controller;

import com.jungle.springboot.security.exception.BusinessException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jungle
 * @version V1.0
 * @date 2019/5/28
 * 描述：主页控制器
 * copyright © 2019- .com
 */
@Controller
public class IndexController {

    /**
     * 跳转： 主页.
     *
     * @return Object
     */
    @RequestMapping(path = {"/index"})
    public Object index() {

        return "index";
    }



    /**
     * 跳转： 正常访问资源页.
     *
     * @return Object
     */
    @RequestMapping(path = {"/resource/a"}, method = RequestMethod.GET)
    @RequiresPermissions("0001")
    public Object resourceA() {
        return "resource_a";
    }

    /**
     * 跳转： 未授权页面.
     *
     * @return Object
     */
    @RequestMapping(path = {"/resource/b"}, method = RequestMethod.GET)
    @RequiresPermissions("0002")
    public Object resourceB() {

        return "resource_b";
    }

    /**
     * 跳转：接口业务异常。
     *
     * @return object 输出数据
     */
    @RequestMapping(value = {"/resource/c"}, method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("0001")
    public Object resourceC() {
        if ("k".equals("k")) {
            Object data = new Object();
            throw new BusinessException("99999999","业务异常", data);
        }
        return "不可能访问的地方";
    }

    /**
     * 跳转：全局异常。
     *
     * @return object 输出数据
     */
    @RequestMapping(value = {"/resource/d"}, method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("0001")
    public Object resourceD() {
        if ("k".equals("k")) {
            throw new RuntimeException("未知异常");
        }
        return null;
    }

}
