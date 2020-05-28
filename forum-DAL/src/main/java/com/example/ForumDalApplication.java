package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
@EnableDubbo()
@DubboComponentScan()
@SpringBootApplication
public class ForumDalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumDalApplication.class, args);
		System.out.println("localhost:8080");
	}

}
