package com.example.controller;

import com.example.po.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("page",list);
        return "user/list";
    }

    //用户点击add按钮，跳转到新增用户页面
    @RequestMapping("/toadd")
    public String toAdd(){
        return "user/userAdd";
    }

    //保存新增用户数据
    @PostMapping("/add")
    public String save(User user){
        userService.add(user);
        return "redirect:/";
    }

    //跳转到编辑页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id") Long id){
        //读取对应id用户信息
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        //跳转到编辑页面
        return "user/userEdit";
    }

    //保存修改用户信息
    @RequestMapping("/update")
    public String update(User user){
        userService.update(user.getId(),user);
        return "redirect:/";
    }

    //删除用户信息
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }

}
