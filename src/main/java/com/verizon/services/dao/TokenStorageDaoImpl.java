package com.verizon.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class TokenStorageDaoImpl implements TokenStorageDao {

    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    public TokenStorageDaoImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(String owner, String token) {
        ValueOperations<String, String> stringValueOperations = redisTemplate.opsForValue();
        stringValueOperations.set(owner, token, 2, TimeUnit.MINUTES);
    }

    @Override
    public String findTokenByKey(String key) {
        String token = (String) redisTemplate.opsForValue().get(key);
        return token;
    }


}
