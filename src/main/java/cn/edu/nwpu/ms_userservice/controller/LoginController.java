package cn.edu.nwpu.ms_userservice.controller;

import cn.edu.nwpu.ms_userservice.domain.User;
import cn.edu.nwpu.ms_userservice.repository.UserRepository;
import cn.edu.nwpu.ms_userservice.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Author: wkx
 * @Date: 2019/5/20 19:29
 * @Version: v1.0
 * @Description:
 */
@RestController("/user")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User login(User user){
        if (userService.login(user)){
            return user;
        }else {
            return null;
        }
    }

    @PostMapping("/regist")
    public User regist(User user){
        if (userService.regist(user)){
            return user;
        }else {
            return null;
        }
    }

    @GetMapping("/check/{userName}")
    public User checkUser(@PathVariable String userName){
        return userRepository.findByUserName(userName);
    }
}
