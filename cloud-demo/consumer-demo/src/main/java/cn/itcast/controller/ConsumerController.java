package cn.itcast.controller;

import cn.itcast.pojo.User;
import lombok.val;
import org.springframework.cloud.client.ServiceInstance;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
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

//    @Autowired
//    RibbonLoadBalancerClient ribbonLoadBalancerClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        //直接访问
//        String url = "http://127.0.0.1:8081/user/1";
//        return restTemplate.getForObject(url, User.class);

        //获取注册中心的服务列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        String url ="http://" + instances.get(0).getHost() + ":" + instances.get(0).getPort() + "/user/" + id;
//        return restTemplate.getForObject(url, User.class);


        //负载均衡原理  LoadBalancerInterceptor 拦截所有请求
        //方式1 负载均衡
//        ServiceInstance serviceInstance = ribbonLoadBalancerClient.choose("user-service");
//        String url ="http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
//        return restTemplate.getForObject(url, User.class);

        //方式2 负载均衡  RestTemplate加注解@LoadBalanced
        String url = "http://user-service/user/1";
        return restTemplate.getForObject(url, User.class);


    }

}
