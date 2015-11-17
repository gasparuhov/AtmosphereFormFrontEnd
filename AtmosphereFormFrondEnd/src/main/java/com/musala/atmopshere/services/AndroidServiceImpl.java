package com.musala.atmopshere.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.musala.atmopshere.utils.PropertiesParser;



@Service
public class AndroidServiceImpl implements AndroidService {

	public String getAndroidsFromServer() {
//		final String uriAndroids = "http://localhost:8080/Atmosphere/androids";
		final  String uriAndroids = PropertiesParser.getDomaain() + "androids";
		System.out.println("androids:" + uriAndroids );
		
	    RestTemplate restTemplate = new RestTemplate();
	    String androids = restTemplate.getForObject(uriAndroids, String.class);
	     
	    return androids;

	}
	
	
}
