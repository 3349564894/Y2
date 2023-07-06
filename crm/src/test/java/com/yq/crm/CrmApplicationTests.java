package com.yq.crm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yq.crm.entity.User;
import com.yq.crm.mapper.UserMapper;
import com.yq.crm.service.RoleService;
import com.yq.crm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import javax.annotation.Resource;

@SpringBootTest
class CrmApplicationTests {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserMapper userMapper;

    @Resource
    UserMapper mapper;

    @Test
    public void testShiro() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("usr_role_id",queryWrapper.getSqlSelect());
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user.getUsrId());
    }

}
