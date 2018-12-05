package com.test.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.service.ITestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-mybatis.xml"})
public class MainTest extends AbstractJUnit4SpringContextTests {
	
	@Resource(name = "testService")
	ITestService testService;
	
	@Test
	public void getPojo(){
		System.out.println(testService.getTestPojo());
	}
}