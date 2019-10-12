package cn.itcast.service;

import cn.itcast.pojo.User;

/**
 * @author huangyi
 * @date 2019/10/12 11:38
 */
public class UserClientImpl implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("未找到");
        return user;
    }
}
