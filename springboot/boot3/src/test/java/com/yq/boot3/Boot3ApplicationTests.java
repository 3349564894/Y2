package com.yq.boot3;

import com.yq.entity.Role;
import com.yq.entity.User;
import com.yq.repository.RoleRepository;
import com.yq.repository.UserRepository;
import com.yq.vo.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class Boot3ApplicationTests {

    @Resource
    private UserRepository userRepository;
    @Resource
    private RoleRepository roleRepository;

    @Test
    void contextLoads() {
        UserInfo userInfo = userRepository.getUserInfo(4);
        System.out.println(userInfo.getUserName());
    }

    @Test
    public void testFindId() {
        User user = userRepository.findByUsrId(22);
        System.out.println("姓名：" + user.getUsrName());
        System.out.println("密码： " + user.getUsrPassword());
        System.out.println("密码： " + user.getRole().getRoleName());
    }

    @Test
    public void testFindId1() {
        List<Role> roleList = roleRepository.findByRoleId(3);
        for (Role role : roleList) {
            System.out.println("角色名：" + role.getRoleName());
            System.out.println("权限名： " + role.getRoleDesc());
            System.out.println("用户数量： " + role.getUserSet().size());
            Iterator<User> iterator = role.getUserSet().iterator();
            while (iterator.hasNext()) {
                System.out.println("用户编号:" + iterator.next().getUsrId());
//                System.out.println("用户名:"+iterator.next().getUsrName());
            }
        }
    }

    @Test
    public void testRoleAdd() {
        Role role = new Role("测试角色", "测试身份", 0);
        User user = new User("刘佳伟", "123456", 0, role);
        User user1 = new User("等海风", "123456", 0, role);
        role.getUserSet().add(user);
        role.getUserSet().add(user1);
        roleRepository.save(role);
    }

    @Test
    public void testRoleDelete() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-MM-ss");
        System.out.println(format.format(System.currentTimeMillis()));
//        Role role = roleRepository.getOne(5);
//        roleRepository.delete(role);
    }
}
