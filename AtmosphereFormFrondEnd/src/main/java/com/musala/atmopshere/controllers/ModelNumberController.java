package com.musala.atmopshere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musala.atmopshere.services.ModelNumberService;

@RestController
public class ModelNumberController {

	@Autowired
	ModelNumberService modelNumberService;

	@RequestMapping(value = "/modelNumbers", method = RequestMethod.GET)
	public String getModelNumbersFromServer(
			@RequestParam(required = false, value = "filter") String filterValue) {

		String modelNumbers = modelNumberService.getModelNumberFormServer(filterValue);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MODEL FROM CONTROLLER" + modelNumbers);
		return modelNumbers;

	}
}
