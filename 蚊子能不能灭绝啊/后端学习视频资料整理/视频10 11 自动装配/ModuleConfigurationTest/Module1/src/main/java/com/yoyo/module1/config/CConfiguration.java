package com.yoyo.module1.config;

import com.yoyo.module1.component.C;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CConfiguration {

    @Bean
    public C pig(){
        return new C();
    }
}
