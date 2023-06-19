package com.yq.boot8;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@SpringBootTest
@RunWith(SpringRunner.class)
class Boot8ApplicationTests {

    private Jedis jedis;
    @Test
    void contextLoads() {
    }

    @Test
    public void testString(){
        jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("root"); //权限认证
        jedis.set("name","yq"); //key-value
        System.out.println(jedis.get("name")); //获取数据,key
        jedis.append("name","+cjm");
        System.out.println(jedis.get("name")); //获取数据,key
        jedis.del("name"); //删除键，key
        System.out.println(jedis.get("name")); //获取不到了，删除成功
        jedis.mset("name","cjm","sex","男","age","18"); //添加多个
        jedis.incr("age"); //加一
        System.out.println(jedis.get("name")+"\n"+jedis.get("sex")+"\n"+jedis.get("age"));
    }
}