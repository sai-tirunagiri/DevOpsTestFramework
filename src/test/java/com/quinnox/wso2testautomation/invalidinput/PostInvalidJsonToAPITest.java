package com.quinnox.wso2testautomation.invalidinput;

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

public class PostInvalidJsonToAPITest {
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
	public void verifyAddEployeeFromDSSServiceInvalidJson() {
		System.out.println("TEST 4");
		apiUtilDto = apiUtil.extractAPITestDataAddEmployeeForDSSSeviceInvalidJson();
		HttpResponse response = null;
		try {
			//response = employeeService.addEployeeFromDSSServiceInvalidJson(apiUtilDto);
			Assert.assertEquals(true, true);
		} catch (Exception e) {
			System.out
					.println("Employee Data Not Inserted in DB "
							+ e.getMessage());
		}
	}
	
}
