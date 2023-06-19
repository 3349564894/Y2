import com.yq.entity.SysUser;
import com.yq.service.SysUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class SysUserTest {

    private Logger logger = Logger.getLogger(SysUserTest.class);


    public void setUp() throws Exception {
    }

    @Test
    public void testGetUserList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SysUserService sysUserService = (SysUserService) context.getBean("sysUserService");
        SysUser sysUser = new SysUser();
        sysUser.setAccount("test测试");
        System.out.println(sysUserService.add(sysUser));
//      SysUserService userService = context.getBean("sysUserService", SysUserService.class);

//      List<SysUser> userList = new ArrayList<>();
//
//      SysUser userCondition = new SysUser();
//
//      userCondition.setRealName("赵");
//      userCondition.setRoleId(2);
//
//      userList = userService.getList(userCondition);
//
//      for (SysUser user : userList) {
//            logger.debug("testGetUserList account:" + user.getAccount()
//                        + "and realName:" + user.getRealName()
//                        + "and roleId:" + user.getRoleId()
//                        + "and roleName:" + user.getRoleIdName()
//                        + "and address::" + user.getAddress());
//      }

    }
}
