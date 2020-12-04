package com.hunter.framework.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于springBoot的线程池的监控Demo
 */
@SpringBootApplication
@MapperScan("com.hunter.framework.schedule.mapper")
public class SBThreadPoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBThreadPoolApplication.class, args);
	}

}
