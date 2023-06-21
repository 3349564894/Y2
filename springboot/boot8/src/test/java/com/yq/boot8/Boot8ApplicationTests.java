package com.yq.boot8;

import com.yq.boot8.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
class Boot8ApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate redisTemplate;
    private Jedis jedis;

    @Test
    void contextLoads() {
    }

    @Test
    public void testString() {
//        stringRedisTemplate.opsForValue().set("name","cjm");
//        Assert.assertEquals("cjm",stringRedisTemplate.opsForValue().get("name"));
//        User user = new User(1L,"cjm","123456",1L,1);
//        ValueOperations<String,User> operations = redisTemplate.opsForValue();
//        operations.set("crm",user);
//        User user1 = operations.get("crm");
//        System.out.println(user1.getUsr_name());
//        stringRedisTemplate.delete("crm");
        stringRedisTemplate.opsForValue().set("test", "100", 60 * 60, TimeUnit.SECONDS);
        stringRedisTemplate.boundValueOps("test").increment(-1);
        stringRedisTemplate.opsForValue().get("test");
        stringRedisTemplate.boundValueOps("test").increment(1);
        stringRedisTemplate.getExpire("test");
        stringRedisTemplate.getExpire("test", TimeUnit.SECONDS);
        stringRedisTemplate.delete("test");
        stringRedisTemplate.hasKey("55555");
        stringRedisTemplate.opsForSet().add("red_123", "1", "2", "3");
        stringRedisTemplate.expire("red_123", 1000, TimeUnit.SECONDS);
        stringRedisTemplate.opsForSet().isMember("red_123", 1);
        stringRedisTemplate.opsForSet().members("red_123");
    }
}