package com.yq.boot3mybatis;

import com.yq.pojo.User;
import com.yq.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class Boot3MybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findTest() {
        User user = userMapper.find(2L);
        if (user != null)
            System.out.println("单个客户信息,编号：" + user.getUsr_id() + "，姓名：" + user.getUsr_name());
        else
            System.out.println("无数据");
    }

    @Test
    void findAllTest() {
        List<User> userList = userMapper.findAll();
        System.out.println("多个客户信息:");
        for (User user1 : userList) {
            System.out.println("编号：" + user1.getUsr_id() + "，姓名：" + user1.getUsr_name());
        }
    }

    @Test
    void insertTest() {
        System.out.println("新增");
        userMapper.insert(new User("刘佳伟", "ljw123456", 1L, 0));
    }

    @Test
    void deleteTest() {
        System.out.println("删除");
        userMapper.delete(23L);
    }

    @Test
    void updateTest() {
        System.out.println("修改");
        userMapper.update(2L, "123456a");
    }
}
