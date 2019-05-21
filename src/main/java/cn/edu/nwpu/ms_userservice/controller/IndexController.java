package cn.edu.nwpu.ms_userservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName IndexController
 * @Author: wkx
 * @Date: 2019/5/20 16:58
 * @Version: v1.0
 * @Description:
 */
@Controller
public class IndexController {

    @GetMapping("/platformlogin")
    public String platformLogin(){
        return "platformlogin";
    }

    @GetMapping("/managelogin")
    public String manageLogin(){
        return "managelogin";
    }

    @GetMapping("/balslogin")
    public String balsLogin(){
        return "balslogin";
    }
}
