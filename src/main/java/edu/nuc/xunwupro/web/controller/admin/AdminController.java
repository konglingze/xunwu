package edu.nuc.xunwupro.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    //后台管理中心UI
    @GetMapping("/admin/center")
    public String adminCenterPage(){
        return "admin/center";
    }
    //后台欢迎页面UI
    @GetMapping("admin/welcome")
    public String welcomePage(){
        return "admin/welcome";
    }
}
