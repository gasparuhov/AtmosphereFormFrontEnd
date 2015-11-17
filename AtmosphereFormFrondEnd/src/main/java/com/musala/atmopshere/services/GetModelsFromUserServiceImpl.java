package com.musala.atmopshere.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.musala.atmopshere.utils.PropertiesParser;

@Service
public class GetModelsFromUserServiceImpl implements GetModelsFromUserService{

	@Override
	public String getModelsFomUserFromServer(String filter) {
		
		final String uriModelsFromUser = PropertiesParser.getDomaain() + "reports/modelNumbers?author=" + filter; 
		RestTemplate restTamplate = new RestTemplate();
		String modelsFromUser = restTamplate.getForObject(uriModelsFromUser, String.class);
		return modelsFromUser;
	}

}
