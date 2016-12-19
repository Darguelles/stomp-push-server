package com.verizon.services.dao;

public interface TokenStorageDao {

    void save(String owner, String token);

    String findTokenByKey(String key);

}
