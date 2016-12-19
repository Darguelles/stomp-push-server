package com.verizon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenStorageService {

    private TokenStorageDao tokenStorageDao;

    @Autowired
    public TokenStorageService(TokenStorageDao tokenStorageDao) {
        this.tokenStorageDao = tokenStorageDao;
    }

    public String save(String owner, String token) {
        tokenStorageDao.save(owner, token);
        return token;
    }

    public String findTokenBySenderCompany(String senderCompany) {
        String token = tokenStorageDao.findTokenByKey(senderCompany);
        return token != null ? token : "";
    }

}
