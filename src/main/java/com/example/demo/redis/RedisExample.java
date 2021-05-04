package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RedisExample  implements CommandLineRunner {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void run(String... args) throws Exception {
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.delete("loda");
//        redisTemplate.delete("loda1");
//        redisTemplate.delete("loda2");
        //redisTemplate.delete("phamviettu");
      redisTemplate.opsForList().leftPop("listvalue");

        //valueExample();
        //listEample();
//        redisTemplate.opsForList().rightPush("listvalue", ".Net");
//        redisTemplate.opsForList().rightPush("listvalue", "Html/css");
//        setExample();


        System.out.println(redisTemplate.opsForSet().members("setvalue"));

    }
    private  void setExample(){
        Set<String> setList = new HashSet<>();
        setList.add("Pham Viet Tu 1");
        setList.add("Pham Viet Tu 2");
        setList.add("Pham Viet Tu 3");
        setList.add("Pham Viet Tu 4");

        redisTemplate.opsForSet().add("setvalue", setList);
        redisTemplate.expire("setvalue",9000);
    }
    private void listEample(){
        List<String> listValue = new ArrayList<>();
        listValue.add("Java");
        listValue.add("C++");
        listValue.add("Android");
        redisTemplate.opsForList().rightPushAll("listvalue", listValue);
        System.out.println("List Value : "+ redisTemplate.opsForList().size("listvalue"));
    }

    private void valueExample() {
        redisTemplate.opsForValue().set("loda1", "value");

        System.out.println("gia tri nhap: "+ redisTemplate.opsForValue().get("loda1"));
    }
}
