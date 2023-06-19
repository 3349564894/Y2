package com.yq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from sys_user where usr_id = #{usr_id}")
    User findByUsrId(Long usr_id);
}
