package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.UserClient;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangyi
 * @date 2019/10/11 0:44
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Resource
    UserClient userClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        if (id % 2 == 0) {
            throw new RuntimeException("未找到");
        }
        return userClient.queryById(id);
    }
}
