package com.yoyo.ditest.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service2 {
    @Autowired
    private RepositoryInterface repository2;

    public String getInfo(){
        return repository2.getUserInfo();
    }
}
