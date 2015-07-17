package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
 
    @RequestMapping("index")
    public String index(Model model){
    	model.addAttribute("test","test");
    	System.out.println("init");
        return "index";
    }
    
    @RequestMapping("getUser")
    @ResponseBody
    public Object getUser(Model model){
    	User user = new User();
    	user.setId(1);
    	user.setName("test");
    	user.setNickname("test1");
        return user;
    }
}