import entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class aopTest {
    @Test
    public void aopTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        UserService service = (UserService) context.getBean("userService");
        User user = new User();
        user.setId(1);
        user.setUsername("小明");
        user.setPassword("123456");
        user.setEmail("3349564894@qq.com");
        service.save(user);
    }
}
