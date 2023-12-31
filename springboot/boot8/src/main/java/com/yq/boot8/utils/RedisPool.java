package com.yq.boot8.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class RedisPool {
    private static String ADDR = "192.168.0.100"; //redis的IP
    private static int PORT = 6379; //redis端口号
    private static String AUTH = "root"; //密码
    private static int MAX_ACTIVE = 1024; //最大连接数
    //控制一个pool最多有多少个状态为idle的jedis实例
    private static int MAX_IDLE = 10000;
    private static int MAX_WAIT = 10000; //最大等待时间
    private static int TIMEOUT = 10000;
    //在borrow一个jedis实例时，是否提前进行validate操作，如果为true，则得到的jedis实例均是可用的
    private static boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;

    /**
     * 初始化redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config,ADDR,PORT,TIMEOUT,AUTH);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取Jedis实例
     */
    public synchronized static Jedis getJedis(){
        try {
            if (jedisPool != null){
                Jedis resource = jedisPool.getResource();
                return resource;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}