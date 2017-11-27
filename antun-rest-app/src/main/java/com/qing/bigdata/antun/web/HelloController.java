package com.qing.bigdata.antun.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 测试项目
 * @author Administrator
 *
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
}
