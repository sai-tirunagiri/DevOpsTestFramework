package com.quinnox.wso2testautomation.apicheck;

import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.quinnox.wso2testautomation.exception.ServiceException;
import com.quinnox.wso2testautomation.model.Employee;
import com.quinnox.wso2testautomation.service.EmployeeService;
import com.quinnox.wso2testautomation.service.EmployeeServiceImpl;
import com.quinnox.wso2testautomation.util.APIUtil;
import com.quinnox.wso2testautomation.util.APIUtilDTO;

public class ApiCheckTest {
	APIUtilDTO apiUtilDto;
	APIUtil apiUtil;
	EmployeeService employeeService;
	Employee employee; 
	
	
	@BeforeTest
	public void init() throws Exception {
		apiUtilDto = new APIUtilDTO();
		apiUtil = new APIUtil();
		employeeService = new EmployeeServiceImpl();
	}
	
	
	@Test
	public void verifyGetWso2APIDSSServiceResponse() {
		System.out.println("TEST 1");
	}
}
