package com.yq.boot8.utils;

import redis.clients.jedis.Jedis;

public class RedisUtil {
    /**
     * 设置key的有效期，单位是秒
     */
    public static Long expire(String key, int exTime) {
        Jedis jedis = null;
        Long result = null;
        try {
            //从redis连接池中获得redis对象
            jedis = RedisPool.getJedis();
            result = jedis.expire(key, exTime);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        } finally {
            jedis.close();
        }
        return result;
    }

    public static String setEx(String key, String value, int exTime) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setex(key, exTime, value);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        } finally {
            jedis.close();
        }
        return result;
    }

    public static String set(String key, String value) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return result;
    }

    public static String get(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        } finally {
            jedis.close();
        }
        return result;
    }

    public static Long del(String key) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        } finally {
            jedis.close();
        }
        return result;
    }
}
