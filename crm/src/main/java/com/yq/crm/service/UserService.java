package com.yq.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.crm.entity.User;
import com.yq.crm.vo.UserInfo;

import java.util.List;


public interface UserService extends IService<User>{

    IPage<User> findUsers(UserInfo userInfo);

    User findUser(String usr_name, String usr_password);

    User findById(Long usr_id);

    List<String> findRoleName();

    User findByName(String usrName);

    int updateUser(User user);

    int deleteUser(Long usrId);

    int addUser(User user);
}
