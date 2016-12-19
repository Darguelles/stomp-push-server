package com.verizon.services;

public interface TokenStorageDao {

    void save(String owner, String token);

    String findTokenByKey(String key);

}
