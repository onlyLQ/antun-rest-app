package com.qing.bigdata.antun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot项目启动类
 * @author Administrator
 *
 */
@SpringBootApplication
@MapperScan("com.qing.bigdata.antun.mapper")
public class AntunRunner {

	public static void main(String[] args) {
		
		SpringApplication.run(AntunRunner.class, args);	
	}
}
