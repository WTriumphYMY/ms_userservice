package cn.edu.nwpu.ms_userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsUserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsUserserviceApplication.class, args);
    }

}
