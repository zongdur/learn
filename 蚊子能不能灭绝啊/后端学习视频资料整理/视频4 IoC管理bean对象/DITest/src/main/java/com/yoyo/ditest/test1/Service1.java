package com.yoyo.ditest.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    @Autowired
    private Repository1 repository1;

    public String getInfo(){
        return repository1.getUserInfo();
    }
}
