package com.yoyo.module2.config;

import com.yoyo.module2.component.C;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CConfiguration {

    @Bean
    public C pig(){
        return new C();
    }
}
