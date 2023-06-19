package com.yq.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.crm.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    Page<User> findUsers(@Param("usr_id") Long usr_id, @Param("usr_name") String usr_name);

    User findUser(@Param("usr_name") String userName, @Param("usr_password") String userPassword);

    User findById(Long usr_id);

    Integer updateUser(User user);

    Integer deleteUser();

    Integer addUser();
}
