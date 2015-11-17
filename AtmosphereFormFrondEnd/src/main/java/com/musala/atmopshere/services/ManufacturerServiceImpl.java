package com.musala.atmopshere.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.musala.atmopshere.utils.PropertiesParser;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{

	@Override
	public String getManufacturerFromServer() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String uriManufacturers =  PropertiesParser.getDomaain() + "manufacturers";
	
		RestTemplate restTamplate = new RestTemplate();
		String manufacturers = restTamplate.getForObject(uriManufacturers, String.class);
		return manufacturers;
	}

}
