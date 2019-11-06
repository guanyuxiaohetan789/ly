package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyou.mapper") // mapper接口的包扫描
public class LyItemServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(LyItemServiceApp.class,args);
    }
}
