package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author huangyi
 * @date 2019/10/11 11:53
 */
@SpringBootApplication
@EnableEurekaServer // 声明这个应用是一个EurekaServer
public class EurekaDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaDemoApplication.class, args);
    }
}
