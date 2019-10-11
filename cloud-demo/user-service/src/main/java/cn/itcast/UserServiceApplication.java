package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author huangyi
 * @date 2019/10/10 23:39
 */
@SpringBootApplication
@MapperScan("cn.itcast.user.mapper")
@EnableDiscoveryClient //@EnableEurekaClient 只支持Eureka   此注释支持zookeeper等
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class,args);
    }
}
