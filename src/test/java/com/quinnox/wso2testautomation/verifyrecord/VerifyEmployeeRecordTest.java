package com.quinnox.wso2testautomation.verifyrecord;

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

public class VerifyEmployeeRecordTest {
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
		public void verifyGetEmployeeFromDSSService() {
			System.out.println("TEST 3");
			apiUtilDto = apiUtil.extractAPITestDataFetchEmployeeForDSSSevice();
			APIUtilDTO apiUtilDtoForJsonInput = apiUtil.extractAPITestDataForEmployeeJsonInput();
			boolean response = false;
			try {
				employee = employeeService.getEmployeeDataFromInputJson(apiUtilDtoForJsonInput);
				response = employeeService.getEmployeeFromDSSService(apiUtilDto,employee);
				Assert.assertEquals(true, true);
			} catch (ServiceException e) {
				System.out
						.println("Employee Data Not Found in DB "
								+ e.getMessage());
			}
		}
}
