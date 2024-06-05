package com.yoyo.module1.config;

import com.yoyo.module1.component.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BConfiguration {

    @Bean
    public B cat(){
        return new B("cat");
    }

    @Bean
    public B dog(){
        return new B("dog");
    }
}
