package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
//            List<Role> lsRole = roleService.getAll();
//            model.addAttribute("lsRole",lsRole);
        return "index";
    }
}
