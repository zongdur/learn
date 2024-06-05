package com.yoyo.ditest;

import com.yoyo.ditest.test2.Service2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test2 {
    @Autowired
    private Service2 service2;

    @Test
    public void test2(){
        System.out.println(service2.getInfo());
    }


}
