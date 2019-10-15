package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.TestService;
@Service("testService")
public class TestServiceImpl implements TestService {

	@Override
	public void print() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("service print test...");
	}

}
