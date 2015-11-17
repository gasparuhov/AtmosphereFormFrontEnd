package com.musala.atmopshere.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.musala.atmopshere.utils.PropertiesParser;

@Service
public class ModelServiceImpl implements ModelService {

	@Override
	public String getModelsFromServer(String filter) {
		String uriModel = PropertiesParser.getDomaain() + "models?filter="
				+ filter;
		System.out.println(uriModel);
		RestTemplate restTamplate = new RestTemplate();
		String models = restTamplate.getForObject(uriModel, String.class);
		System.out.println(models);
		return models;

	}

}
