package com.yoyo.module2.config;

import com.yoyo.module2.component.B;
import com.yoyo.module2.condition.ExistACondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("rain")
public class BConfiguration {

    @Bean
    @Conditional(ExistACondition.class)
    public B cat(){
        return new B("cat");
    }

    @Bean
    public B dog(){
        return new B("dog");
    }
}
