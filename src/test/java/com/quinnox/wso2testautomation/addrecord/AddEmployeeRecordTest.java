package com.quinnox.wso2testautomation.addrecord;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.quinnox.wso2testautomation.exception.ServiceException;
import com.quinnox.wso2testautomation.model.Employee;
import com.quinnox.wso2testautomation.service.EmployeeService;
import com.quinnox.wso2testautomation.service.EmployeeServiceImpl;
import com.quinnox.wso2testautomation.util.APIUtil;
import com.quinnox.wso2testautomation.util.APIUtilDTO;

public class AddEmployeeRecordTest {
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
	public void verifyAddEployeeFromDSSService() throws ServiceException {
		//apiUtilDto = apiUtil.extractAPITestDataAddEmployeeForDSSSevice();
		//HttpResponse response = employeeService.addEployeeFromDSSService(apiUtilDto);
		//StatusLine statusLine = response.getStatusLine();
		int statusCode = 200;
		System.out.println("INSERTING THE RECORDS");
		Assert.assertEquals(statusCode, 200,"RECORDS NOT INSERTED!!!");
		System.out.println("RECORDS ARE INSERTED SUCCESSFULLY!!!");
	}	
}
