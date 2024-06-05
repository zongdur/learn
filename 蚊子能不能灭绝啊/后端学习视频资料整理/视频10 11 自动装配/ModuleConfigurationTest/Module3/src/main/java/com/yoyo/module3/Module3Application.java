package com.yoyo.module3;

import com.yoyo.module3.bean.DemoDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;
import java.util.ServiceLoader;

public class Module3Application {

    public static void main(String[] args) {
//        ServiceLoader<DemoDao> serviceLoader=ServiceLoader.load(DemoDao.class);
//        serviceLoader.iterator().forEachRemaining(dao->{
//            System.out.println(dao);
//        });
        List<DemoDao> demoDaos= SpringFactoriesLoader.loadFactories(DemoDao.class,Module3Application.class.getClassLoader());
        demoDaos.forEach(dao->{
            System.out.println(dao);
        });
        System.out.println("----------------------------");
        List<String> daoClassNames=SpringFactoriesLoader.loadFactoryNames(DemoDao.class,Module3Application.class.getClassLoader());
        daoClassNames.forEach(dao->{
            System.out.println(dao);
        });

    }

}
