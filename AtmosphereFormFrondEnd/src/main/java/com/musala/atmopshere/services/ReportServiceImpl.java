package com.musala.atmopshere.services;



import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.musala.atmopshere.utils.Constants;
 



@Service
public class ReportServiceImpl implements ReportService{

	@Override
	public  ResponseEntity<String> postReport(String report) {
		System.out.println("!!!  post report !!!");
		final String uri = "http://localhost:8080/Atmosphere/reports";
		LinkedMultiValueMap<String,String> map = new LinkedMultiValueMap<>();
	
		JSONObject json = new JSONObject(report);
		
//		map.add("android", (json.get("android")).toString());
//		System.out.println(">>>>> JSON ANDORD: " +  json.get("android"));
//		map.add("phoneModelNumber",json.get("phoneModelNumber").toString());
//		System.out.println();
////		map.add("phoneModel",json.getString("phoneModel"));
////		map.add("manufacturer",json.getString("phoneModel"));		
//		map.add("stepsToReproduce", json.getString("stepsToReproduce"));
//		map.add("expectedResult", json.getString("expectedResult"));
//		map.add("actualResult", json.getString("actualResult"));
//		map.add("application", json.getString("application"));
//		map.add("appVersion", json.getString("appVersion"));
//		map.add("appURL", json.getString("appURL"));
//		map.add("description", json.getString("description"));
//		map.add("author", json.getString("author"));
		LinkedMultiValueMap<String,String> fullMap = new LinkedMultiValueMap<>();
		fullMap.add("report", report);
		
		
		
		

		  
		  
		  HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		

		  
		  HttpEntity<LinkedMultiValueMap<String, String>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, String>>(
				  fullMap, headers);
		  System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> BeFORE REST TEMPLETE");
		  RestTemplate restTemplate = new RestTemplate();
		  ResponseEntity<String> result =  restTemplate.postForEntity(uri, requestEntity, String.class);
		  
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> AFTER RESULT <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> RESULT" + result);
		  return result;
	}

	


}
