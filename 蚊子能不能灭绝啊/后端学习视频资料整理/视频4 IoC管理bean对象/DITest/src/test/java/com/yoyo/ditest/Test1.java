package com.yoyo.ditest;

import com.yoyo.ditest.test1.Service1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Test1 {

    @Autowired
    private Service1 service1;

    @Test
    public void test1(){
        System.out.println(service1.getInfo());
        assertEquals("User Info 2",service1.getInfo());
    }
}
