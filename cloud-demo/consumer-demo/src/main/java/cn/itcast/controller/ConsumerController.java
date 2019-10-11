package cn.itcast.controller;

import cn.itcast.pojo.User;
import org.springframework.cloud.client.ServiceInstance;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangyi
 * @date 2019/10/11 0:44
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        //String url = "http://127.0.0.1:8081/user/1";

        List<ServiceInstance> instances = discoveryClient.getInstances("user-services");
        String url = instances.get(0).getHost() + instances.get(0).getPort() + "/user/" + id;

        return restTemplate.getForObject(url, User.class);
    }

}
