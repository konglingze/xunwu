package edu.nuc.xunwupro.web.controller;

import edu.nuc.xunwupro.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/get")
    @ResponseBody
    //返回标准结果集，并转化为Json
    public ApiResponse get() {
        return ApiResponse.ofMessage(200, "请求发送成功");
    }

    @GetMapping("404")
    public String notFoundPage(){
        return "404";
    }
    @GetMapping("403")
    public String accessError(){
        return "403";
    }
    @GetMapping("500")
    public String internalErrror(){
        return "500";
    }
    @GetMapping("/logout")
    public String logoutPage(){
        return "logout";
    }
    @GetMapping("/admin/login")
    public String adminLoginPage(){
        return "admin/login";
    }
}
