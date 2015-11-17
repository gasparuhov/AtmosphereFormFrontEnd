package com.musala.atmopshere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musala.atmopshere.services.FilterModelNumbersService;

@RestController
public class FilterModelNumbersController {

	@Autowired
	FilterModelNumbersService filterModelService;
	
	@RequestMapping(value = "/modelNumbers/filter", method = RequestMethod.GET)
	public String filterManufacturerAndModels(@RequestParam(required = false, value = "filter") String filterValue){
		
		String filteredMnaufacturerAndModles = filterModelService.getManufacturerAndModelsByModelNumberFormServer(filterValue);
		return filteredMnaufacturerAndModles;
		
	}
}
