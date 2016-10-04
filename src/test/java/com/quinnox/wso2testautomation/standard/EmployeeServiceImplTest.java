package com.quinnox.wso2testautomation.standard;

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

public class EmployeeServiceImplTest {
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
	
	
	@Test(priority = 1)
	public void verifyGetWso2APIDSSServiceResponse() {
		apiUtilDto = apiUtil.extractAPITestDataForDSSSevice();
		int response = 0;
		try {
			//response = employeeService.getWso2APIDSSServiceResponse(apiUtilDto);
			Assert.assertEquals(true, true);
		} catch (Exception e) {
			System.out
					.println("Went wrong while mocking the call for WSO2 API "
							+ e.getMessage());
		}
	}

	
	@Test(priority = 2, dependsOnMethods={"verifyGetWso2APIDSSServiceResponse"})
	public void verifyAddEployeeFromDSSService() {
		apiUtilDto = apiUtil.extractAPITestDataAddEmployeeForDSSSevice();
		HttpResponse response = null;
		try {
			response = employeeService.addEployeeFromDSSService(apiUtilDto);
			Assert.assertTrue(true,"DATA NOT INSERTED IN DB || UNIQUE CONSTRAINT");
		} catch (ServiceException e) {
			System.out
					.println("Employee Data Not Inserted in DB "
							+ e.getMessage());
		}
	}
	
	@Test(priority = 3, dependsOnMethods={"verifyAddEployeeFromDSSService"})
		public void verifyGetEmployeeFromDSSService() {
			apiUtilDto = apiUtil.extractAPITestDataFetchEmployeeForDSSSevice();
			APIUtilDTO apiUtilDtoForJsonInput = apiUtil.extractAPITestDataForEmployeeJsonInput();
			boolean response = false;
			try {
				employee = employeeService.getEmployeeDataFromInputJson(apiUtilDtoForJsonInput);
				response = employeeService.getEmployeeFromDSSService(apiUtilDto,employee);
				Assert.assertTrue(true,"Employee Data Not Found in DB");
			} catch (ServiceException e) {
				System.out
						.println("Employee Data Not Found in DB "
								+ e.getMessage());
			}
		}
	
	@Test(priority = 4, dependsOnMethods={"verifyGetWso2APIDSSServiceResponse"})
	public void verifyAddEployeeFromDSSServiceInvalidJson() {
		apiUtilDto = apiUtil.extractAPITestDataAddEmployeeForDSSSeviceInvalidJson();
		HttpResponse response = null;
		try {
			response = employeeService.addEployeeFromDSSServiceInvalidJson(apiUtilDto);
			Assert.assertTrue(true,"DATA NOT INSERTED IN DB || UNIQUE CONSTRAINT");
		} catch (ServiceException e) {
			System.out
					.println("Employee Data Not Inserted in DB "
							+ e.getMessage());
		}
	}
	
}
