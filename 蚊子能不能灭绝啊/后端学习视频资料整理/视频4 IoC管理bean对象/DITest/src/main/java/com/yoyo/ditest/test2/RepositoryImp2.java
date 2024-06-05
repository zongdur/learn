package com.yoyo.ditest.test2;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryImp2 implements RepositoryInterface{
    @Override
    public String getUserInfo() {
        return "User Info 2-2";
    }
}
