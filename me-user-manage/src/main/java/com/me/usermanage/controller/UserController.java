package com.me.usermanage.controller;

import com.me.usermanage.bean.UserInfo;
import com.me.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller+@ResponseBody
//使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/allUsers")
    //@RequestMapping可以指定GET、POST请求方式
    public List<UserInfo> getAllUsers() {
        return userService.getUserInfoListAll();
    }

    @RequestMapping("/addUser")
    public String addUser(UserInfo userInfo) {
        userService.addUser(userInfo);
        return "add successfully";
    }

    @RequestMapping("updateUser")
    public String updateUser(UserInfo userInfo) {
        userService.updateUser(userInfo);
        return "update successfully";
    }

    @RequestMapping("updateUserByName")
    public String updateUserByName(UserInfo userInfo) {
        userService.updateUserByName(userInfo.getName(), userInfo);
        return "success";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(UserInfo userInfo) {
        userService.delUser(userInfo);
        return "delete successfully";
    }

    //教程用的get
    @RequestMapping("getUser")
    public UserInfo getUser(String id) {
        return userService.getUserInfo(id);
    }
}