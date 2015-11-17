package com.musala.atmopshere.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.musala.atmopshere.utils.PropertiesParser;

@Service
public class ModelNumberServiceImpl implements ModelNumberService {

	@Override
	public String getModelNumberFormServer(String filter) {

		final String uriModelNumber = PropertiesParser.getDomaain()
				+ "modelNumbers?filter=" + filter;
		RestTemplate restTamplate = new RestTemplate();
		String modelNumbers = restTamplate.getForObject(uriModelNumber,
				String.class);

		return modelNumbers;
	}

}
