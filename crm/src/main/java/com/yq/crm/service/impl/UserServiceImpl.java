package com.yq.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.crm.entity.User;
import com.yq.crm.mapper.UserMapper;
import com.yq.crm.service.UserService;
import com.yq.crm.vo.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> findUsers(UserInfo userInfo) {
        QueryWrapper wrapper = new QueryWrapper();
        //设置条件
        if (null != userInfo.getUsrId() && userInfo.getUsrId() != 0) {
            //设置条件
            wrapper.eq("usr_id", userInfo.getUsrId());wrapper.like("","");
        }
        if (null != userInfo.getUsrName() && userInfo.getUsrName() != "") {
            //设置条件
            wrapper.eq("usr_name", userInfo.getUsrName());
        }
        Page<User> page = new Page<>(userInfo.getCurrent(), 3); //设置分页
        IPage<User> iPage = userMapper.selectPage(page, wrapper);
        return iPage;
    }

    @Override
    public User findUser(String user_name, String user_password) {
        return userMapper.findUser(user_name, user_password);
    }

    @Override
    public User findById(Long usr_id) {
        return userMapper.findById(usr_id);
    }

    @Override
    public List<String> findRoleName() {
        return userMapper.findRoleName();
    }

    @Override
    public User findByName(String usrName) {
        return userMapper.findByName(usrName);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Long usrId) {
        return userMapper.deleteUser(usrId);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

}
