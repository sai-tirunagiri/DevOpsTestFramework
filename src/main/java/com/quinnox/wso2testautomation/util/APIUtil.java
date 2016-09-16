package com.quinnox.wso2testautomation.util;

/**
 * @author anuragg
 *
 */

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;

import com.quinnox.wso2testautomation.constants.AppConstants;


public class APIUtil {

	public int getApiResponse(String Resturl) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		// configure the SSLContext with a TrustManager
		URL url = new URL(Resturl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		return responseCode;
	}

	public HttpResponse postInputDataForDSSService(String url, String inputData, String contentType)
			throws ClientProtocolException, IOException, JSONException {
		HttpPost request = new HttpPost(url);
		StringEntity entity = new StringEntity(inputData);
		entity.setContentType(contentType);
		entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, contentType));
		request.setEntity(entity);
		@SuppressWarnings("unused")
		HttpEntity httpEntity = null;
		HttpResponse response = null;
		HttpClient httpclient = HttpClientBuilder.create().build();
		try {
			response = httpclient.execute(request);
			return response;
		} catch (SocketException se) {
			throw se;
		}
	}

	public APIUtilDTO extractAPITestDataAddEmployeeForDSSSevice() {
		APIUtilDTO apiUtilDTO = null;
		ExcelLib excelUtil = null;

		try {
			apiUtilDTO = new APIUtilDTO();
			excelUtil = new ExcelLib();
			String url = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 2, 1);
			String inputData = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 2, 5);
			String contentType = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 2, 6);
			if (url != null)
				apiUtilDTO.setUrl(url.trim());
			if (inputData != null)
				apiUtilDTO.setInputData(inputData.trim());
			if (contentType != null)
				apiUtilDTO.setContentType(contentType);
			return apiUtilDTO;

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return apiUtilDTO;
	}

	public APIUtilDTO extractAPITestDataFetchEmployeeForDSSSevice() {
		APIUtilDTO apiUtilDTO = null;
		ExcelLib excelUtil = null;

		try {
			apiUtilDTO = new APIUtilDTO();
			excelUtil = new ExcelLib();

			String url = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 3, 1);
			String inputData = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 3, 5);
			String contentType = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 3, 6);
			if (url != null)
				apiUtilDTO.setUrl(url.trim());
			if (inputData != null)
				apiUtilDTO.setInputData(inputData.trim());
			if (contentType != null)
				apiUtilDTO.setContentType(contentType);
			return apiUtilDTO;

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return apiUtilDTO;
	}

	public APIUtilDTO extractAPITestDataForEmployeeJsonInput() {
		APIUtilDTO apiUtilDTO = null;
		ExcelLib excelUtil = null;

		try {
			apiUtilDTO = new APIUtilDTO();
			excelUtil = new ExcelLib();
			String inputData = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 2, 5);
			if (inputData != null)
				apiUtilDTO.setInputData(inputData.trim());
			return apiUtilDTO;

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return apiUtilDTO;
	}
	
	public APIUtilDTO extractAPITestDataAddEmployeeForDSSSeviceInvalidJson() {
		APIUtilDTO apiUtilDTO = null;
		ExcelLib excelUtil = null;

		try {
			apiUtilDTO = new APIUtilDTO();
			excelUtil = new ExcelLib();

			String url = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 4, 1);
			String inputData = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 4, 5);
			String contentType = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 4, 6);
			if (url != null)
				apiUtilDTO.setUrl(url.trim());
			if (inputData != null)
				apiUtilDTO.setInputData(inputData.trim());
			if (contentType != null)
				apiUtilDTO.setContentType(contentType);
			return apiUtilDTO;

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return apiUtilDTO;
	}

	public APIUtilDTO extractAPITestDataForDSSSevice() {
		APIUtilDTO apiUtilDTO = null;
		ExcelLib excelUtil = null;

		try {
			apiUtilDTO = new APIUtilDTO();
			excelUtil = new ExcelLib();

			String url = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 1, 1);
			String inputData = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 1, 5);
			String contentType = excelUtil.getExcelData(AppConstants.EXCEL_SHEET_NAME, 1, 6);
			if (url != null)
				apiUtilDTO.setUrl(url.trim());
			if (inputData != null)
				apiUtilDTO.setInputData(inputData.trim());
			if (contentType != null)
				apiUtilDTO.setContentType(contentType);
			return apiUtilDTO;

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return apiUtilDTO;
	}
}
