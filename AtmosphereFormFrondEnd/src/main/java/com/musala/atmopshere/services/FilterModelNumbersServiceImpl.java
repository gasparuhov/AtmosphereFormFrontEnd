package com.musala.atmopshere.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.musala.atmopshere.utils.PropertiesParser;

@Service
public class FilterModelNumbersServiceImpl implements FilterModelNumbersService {

	@Override
	public String getManufacturerAndModelsByModelNumberFormServer(String filter) {
	  final String uriModelNumbersFilter = PropertiesParser.getDomaain() + "modelNumbers?filter=" + filter;
	  RestTemplate restTamplate = new RestTemplate();
	  String filteredManufacturerAndModels = restTamplate.getForObject(uriModelNumbersFilter, String.class);
		return filteredManufacturerAndModels;
	}
	
}
