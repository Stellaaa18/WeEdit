package com.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.dao.ITestDao;
import com.test.pojo.TestPojo;
import com.test.service.ITestService;

@Service(value = "testService")
public class TestServiceImpl implements ITestService{

	@Resource
	ITestDao testDao;
	
	@Override
	public TestPojo getTestPojo() {
		return testDao.getTestPojo();
	}
	
}

