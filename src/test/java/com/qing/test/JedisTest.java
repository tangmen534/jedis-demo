package com.qing.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        jedis = new Jedis("10.216.23.176",6379);
        jedis.auth("1234");
        jedis.select(0);
    }

    @Test
    void stringTest(){
        String result=jedis.set("name", "Jack");
        System.out.println(result);
        String name=jedis.get("name");
        System.out.println(name);
    }

    @Test
    void hashTest(){
        jedis.hset("user:1","name","zs");
        jedis.hset("user:1", "age","21");
        System.out.println(jedis.hgetAll("user:1"));
    }

    @AfterEach
    void tearDown(){
        if(jedis!=null){
            jedis.close();
        }
    }
}
