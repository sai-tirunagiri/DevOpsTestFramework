package com.quinnox.wso2testautomation.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.quinnox.wso2testautomation.exception.ServiceException;
import com.quinnox.wso2testautomation.model.Employee;
import com.quinnox.wso2testautomation.model.MyPojo;
import com.quinnox.wso2testautomation.util.APIUtil;
import com.quinnox.wso2testautomation.util.APIUtilDTO;

public class EmployeeServiceImpl implements EmployeeService {

	APIUtil apiUtil;
	Gson gson;
	Employee employee;

	public EmployeeServiceImpl() {
		apiUtil = new APIUtil();
		gson = new Gson();
		employee = new Employee();
	}

	@Override
	public int getWso2APIDSSServiceResponse(APIUtilDTO apiUtilDTO) throws ServiceException {
		System.out.println("[Enter into EmployeeServiceImpl.getWso2APIDSSServiceResponse...]");
		int response = 0;
		try {
			response = apiUtil.getApiResponse(apiUtilDTO.getUrl());

		} catch (Exception ex) {
			System.out.println("Exception raised while checking with api response code: " + ex.getMessage());
			throw new ServiceException("Problem occured during API call");
		}
		System.out.println("[Exit into EmployeeServiceImpl.getWso2APIDSSServiceResponse...]");
		return response;
	}

	@Override
	public HttpResponse addEployeeFromDSSService(APIUtilDTO apiUtilDTO) throws ServiceException {
		System.out.println("[Enter into EmployeeServiceImpl.addEployeeFromDSSService...]");
		HttpResponse response = null;
		try {
			response = apiUtil.postInputDataForDSSService(apiUtilDTO.getUrl(), apiUtilDTO.getInputData(),
					apiUtilDTO.getContentType());
			if (response.toString().contains("200"))
				System.out.println("Employee Data inserted into DB through DSS SErvice...");
			else
				System.out.println("DSS API Not Working...");
		} catch (Exception ex) {
			System.out.println("Exception raised while checking with api response code: " + ex.getMessage());
			throw new ServiceException("Problem occured during API call");
		}
		System.out.println("[Exit into EmployeeServiceImpl.addEployeeFromDSSService...]");
		return response;

	}

	@Override
	public boolean getEmployeeFromDSSService(APIUtilDTO apiUtilDTO, Employee employee) throws ServiceException {
		System.out.println("[Enter into EmployeeServiceImpl.addEployeeFromDSSServiceInvalidJson...]");
		HttpResponse response = null;
		boolean compareResult = false;
		try {
			response = apiUtil.postInputDataForDSSService(apiUtilDTO.getUrl(), apiUtilDTO.getInputData(),
					apiUtilDTO.getContentType());
			HttpEntity entity = response.getEntity();
			String responseContent = EntityUtils.toString(entity);
			JSONObject xmlJSONObj = XML.toJSONObject(responseContent);
			String jsonPrettyPrintString = xmlJSONObj.toString(4);
			MyPojo responceEmployeeJson = gson.fromJson(jsonPrettyPrintString, MyPojo.class);
			if (employee.getEMP_NAME().equals(responceEmployeeJson.getResult().getNAME().trim())) {
				System.out.println("Employee Data Found in Target System...");
				compareResult = true;
			} else {
				System.out.println("Employee Data Not Found in Target System...");
				compareResult = false;
			}

		} catch (Exception ex) {
			System.out.println("Exception raised while checking with api response code: " + ex.getMessage());
			throw new ServiceException("Problem occured during API call");
		}
		System.out.println("[Exit into EmployeeServiceImpl.addEployeeFromDSSServiceInvalidJson...]");
		return compareResult;

	}

	@Override
	public HttpResponse getEmployeeInfoFromDSSService(APIUtilDTO apiUtilDTO) throws ServiceException {
		System.out.println("[Enter into EmployeeServiceImpl.addEployeeFromDSSServiceInvalidJson...]");
		HttpResponse response = null;
		try {
			response = apiUtil.postInputDataForDSSService(apiUtilDTO.getUrl(), apiUtilDTO.getInputData(),
					apiUtilDTO.getContentType());

		} catch (Exception ex) {
			System.out.println("Exception raised while checking with api response code: " + ex.getMessage());
			throw new ServiceException("Problem occured during API call");
		}
		System.out.println("[Exit into EmployeeServiceImpl.addEployeeFromDSSServiceInvalidJson...]");
		return response;

	}

	@Override
	public Employee getEmployeeDataFromInputJson(APIUtilDTO apiUtilDTO) throws ServiceException {
		System.out.println("[Enter into EmployeeServiceImpl.getEmployeeDataFromInputJson...]");
		try {
			employee = gson.fromJson(apiUtilDTO.getInputData(), Employee.class);
		} catch (Exception ex) {
			System.out.println("Exception raised while getting Employee data from JSON : " + ex.getMessage());
			throw new ServiceException("Problem occured during JSON Parsing");
		}
		System.out.println("[Exit into EmployeeServiceImpl.getEmployeeDataFromInputJson...]");
		return employee;
	}

}
