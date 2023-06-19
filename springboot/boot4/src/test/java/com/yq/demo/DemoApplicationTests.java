package com.yq.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.mapper.UserMapper;
import com.yq.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.findByUsrId(2L);
        System.out.println("姓名：" + user.getUsrName());
    }

    @Test
    void testFindAll() {
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println("姓名" + user.getUsrName());
        }
    }

    @Test
    void testFind() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("usr_name", "刘佳伟");
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            byte[] key = user.getUsrPassword().getBytes();
            System.out.println("姓名:" + user.getUsrName() + "  ,密码：" + new BASE64Encoder().encode(key));
        }
    }

    @Test
    void testInsert() {
        while (true) {
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
            userMapper.insert(new User("cjm", "12312412134", 1L, 0));
        }
    }

    @Test
    void tesUpdate() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("usr_id", "24");
        userMapper.update(new User(null, "f32]3657[-g34=43", null, null), wrapper);
    }

    @Test
    void tesDelete() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("usr_name", "cjm");
        userMapper.delete(wrapper);
    }

    @Test
    void tesFindPage() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("usr_name", "cjm");
        Page<User> userPage = new Page<>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(userPage, wrapper);
        System.out.println("总记录数：" + userIPage.getTotal());
        System.out.println("总页数：" + userIPage.getPages());
        System.out.println("总当前页数：" + userIPage.getCurrent());
        System.out.println("每页记录数：" + userIPage.getSize());
        System.out.println("当前记录：");
        for (User user : userIPage.getRecords()) {
            System.out.println("姓名：" + user.getUsrName());
        }
    }
}
