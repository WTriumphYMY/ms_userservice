package cn.edu.nwpu.ms_userservice.service.impl;

import cn.edu.nwpu.ms_userservice.domain.User;
import cn.edu.nwpu.ms_userservice.repository.UserRepository;
import cn.edu.nwpu.ms_userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserServiceImpl
 * @Author: wkx
 * @Date: 2019/5/20 20:11
 * @Version: v1.0
 * @Description: 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    private static final long TIME_OUT = 1800L;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    @Override
    public boolean login(User user) {
        User checkUser = userRepository.findByUserName(user.getUserName());
        if (user.getUserPassword().equals(checkUser.getUserPassword())){
            redisTemplate.opsForValue().set(user.getUserName(), user, TIME_OUT, TimeUnit.SECONDS);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean regist(User user) {
        if (userRepository.findByUserName(user.getUserName()) != null){
            return false;
        }else {
            userRepository.save(user);
            return true;
        }
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        //创建一个模板类
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        //将刚才的redis连接工厂设置到模板类中
        template.setConnectionFactory(factory);
        return template;
    }
}
