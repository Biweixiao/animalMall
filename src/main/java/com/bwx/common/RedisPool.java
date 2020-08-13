package com.bwx.common;

import com.bwx.utils.PropertiesUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author BiWeixiao
 * @time 2019-11-18 11:17
 */

public class RedisPool {
    private static JedisPool pool;
    private static Integer maxTotal = 20;//最大连接数
    private static Integer maxIdle = 20;
    private static Integer minIdle = 1;
    private static Boolean testOnBorrow = true;
    private static Boolean testOnReturn = false;
    //    private static String redisPassword = PropertiesUtil.getProperty("spring.redis.password");
//    private static String redisIp = PropertiesUtil.getProperty("spring.redis.host");
//    private static Integer redisPort = Integer.parseInt(PropertiesUtil.getProperty("spring.redis.port"));
    private static String redisPassword = "B3.1415926";
    private static String redisIp = "47.94.223.95";
    private static Integer redisPort = 6379;

    private static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        config.setBlockWhenExhausted(true);//连接耗尽时是否阻塞，默认为true
        pool = new JedisPool(config, redisIp, redisPort, 1000 * 10, redisPassword);
    }

    static {
        initPool();
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void returnResource(Jedis jedis) {
        pool.returnResource(jedis);
    }

    public static void returnBrokenResource(Jedis jedis) {
        pool.returnBrokenResource(jedis);
    }

}
