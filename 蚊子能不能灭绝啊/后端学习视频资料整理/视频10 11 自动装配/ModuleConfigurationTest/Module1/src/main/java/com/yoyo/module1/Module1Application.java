package com.yoyo.module1;

import com.yoyo.module1.config.ModuleConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class Module1Application {

    public static void main(String[] args) {

        ApplicationContext ctx=new AnnotationConfigApplicationContext(ModuleConfiguration.class);
        System.out.println("------------------------------------");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);

    }

}
