package com.yq.crm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.crm.entity.User;

import java.awt.print.Pageable;
import java.util.List;


public interface UserService {

    Page<User> findUsers(Page page, QueryWrapper wrapper);

    User findUser(String usr_name, String usr_password);

    User findById(Long usr_id);

    User findByName(String usrName);

    Integer updateUser(User user);

    Integer deleteUser(Long usrId);

    Integer addUser(User user);
}
