package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
 
    @RequestMapping("index")
    public String index(Model model){
    	model.addAttribute("test","test");
    	System.out.println("init");
        return "index";
    }
}