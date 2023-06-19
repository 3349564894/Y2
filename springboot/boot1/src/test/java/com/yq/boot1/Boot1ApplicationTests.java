package com.yq.boot1;

import com.yq.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot1ApplicationTests {

    @Resource
    private DemoService demoService;

    @Test
    public void contextLoads() {
        String msg = demoService.sayHello();
        System.out.println(msg);
    }

}
