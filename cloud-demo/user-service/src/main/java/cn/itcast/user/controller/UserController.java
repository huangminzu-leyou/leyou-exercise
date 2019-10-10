package cn.itcast.user.controller;

import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangyi
 * @date 2019/10/10 23:50
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return this.userService.queryById(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public User add() {
        User user = new User();
        user.setName("12");
        user.setAge(1);
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setPassword("1223432");
        user.setSex(1);
        return this.userService.add(user);
    }
}
