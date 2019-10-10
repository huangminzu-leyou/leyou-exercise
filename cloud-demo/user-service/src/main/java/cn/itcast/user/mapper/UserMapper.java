package cn.itcast.user.mapper;

import cn.itcast.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huangyi
 * @date 2019/10/10 23:49
 */
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>{
}