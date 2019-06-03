package com.top.sstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.top.sstore.dao")
public class SstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SstoreApplication.class, args);
    }
}
