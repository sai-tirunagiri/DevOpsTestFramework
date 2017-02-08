/**
 * 
 */
package com.quinnox.wso2testautomation.service;

import org.apache.http.HttpResponse;

import com.quinnox.wso2testautomation.exception.ServiceException;
import com.quinnox.wso2testautomation.model.Employee;
import com.quinnox.wso2testautomation.util.APIUtilDTO;

/**
 * @author anuragg
 * 
 */
public interface EmployeeService {

	public Employee getEmployeeDataFromInputJson(APIUtilDTO apiUtilDTO)throws ServiceException;
	public int getWso2APIDSSServiceResponse(APIUtilDTO apiUtilDTO)throws ServiceException;
	public boolean getEmployeeFromDSSService(APIUtilDTO apiUtilDTO, Employee employee)throws ServiceException;
	public HttpResponse addEployeeFromDSSService(APIUtilDTO apiUtilDTO)throws ServiceException;
	public HttpResponse getEmployeeInfoFromDSSService(APIUtilDTO apiUtilDTO) throws ServiceException;
		
}
