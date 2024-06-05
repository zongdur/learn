package com.yoyo.module2;

import com.yoyo.module2.config.ModuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

@SpringBootApplication
public class Module2Application {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("rain");
        ctx.register(ModuleConfiguration.class);
        ctx.refresh();
        System.out.println("------------------------------------");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);

    }

}
