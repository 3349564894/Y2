package com.yq.repository;

import com.yq.entity.User;
import com.yq.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {
    @Resource
    private UserRepository repository;
    private User user;
    @Resource
    private UserService userService;

    @Test
    public void testFindByUsrId() {
        user = repository.findByUsrId(2);
        System.out.println(user.getUsrId());
        System.out.println(user.getUsrName());
    }

    @Test
    void testFindByUsrNameAndUsrPassword() throws IOException {
        user = repository.findByUsrNameAndUsrPasswordIsNull("lh", "");
        System.out.println("密码: " + new String(new BASE64Decoder().decodeBuffer(user.getUsrPassword())));
    }

    @Test
    void testFindByUsrIdOrUsrName() {
        user = repository.findByUsrIdOrUsrName(100, "曹佳敏是个猪");
        System.out.println("姓名：" + user.getUsrName());
    }

    @Test
    void testFindByUsrNameOrderByUsrIdDesc() {
        List<User> userList = repository.findByUsrFlagOrderByUsrIdDesc(1);
        for (User u :
                userList) {

            System.out.println("编号：" + u.getUsrId());
            System.out.println("姓名：" + u.getUsrName());
        }
    }

    @Test
    void testFindByUsrNameLike() {
        List<User> userList = repository.findByUsrNameLike("%曹%");
        for (User u :
                userList) {
            System.out.println("编号：" + u.getUsrId());
            System.out.println("姓名：" + u.getUsrName());
        }
    }

    @Test
    void Insert() {
        byte[] psw = "caojiamin123".getBytes(StandardCharsets.UTF_8);
        user = new User("曹佳敏是个猪", (new BASE64Encoder().encode(psw)), 1, 1);
        User result = repository.save(user);
        if (result != null) {
            System.out.println("增加成功");
        } else {
            System.out.println("增加失败");
        }
    }

    @Test
    public void testFindPageByUsrName() {
        int page = 0;
        int size = 2;
        Sort sort = Sort.by(Sort.Direction.DESC, "usrName");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> userPage = repository.findPageByUsrName("", pageable);
        System.out.println("总记录数:" + userPage.getTotalElements());
        System.out.println("总页数:" + userPage.getTotalPages());
        System.out.println("总:" + userPage.get());
        System.out.println("总:" + userPage.getContent());
        System.out.println("总:" + userPage.getPageable().getOffset());
        for (User user1 : userPage.getContent()
        ) {
            System.out.println("编号：" + user1.getUsrId());
            System.out.println("姓名：" + user1.getUsrName());
        }
    }

    @Test
    public void testLikeUsrName() {
        int page = 0;
        int size = 2;
        Sort sort = Sort.by(Sort.Direction.DESC, "usrName");
        Pageable pageable = PageRequest.of(page, size, sort);
        Map map = new HashMap();
        Page<User> userPage = userService.findPageByMap(map, pageable);
        System.out.println("总记录数:" + userPage.getTotalElements());
        for (User user1 : userPage.getContent()
        ) {
            System.out.println("编号：" + user1.getUsrId());
            System.out.println("姓名：" + user1.getUsrName());
        }
    }
}