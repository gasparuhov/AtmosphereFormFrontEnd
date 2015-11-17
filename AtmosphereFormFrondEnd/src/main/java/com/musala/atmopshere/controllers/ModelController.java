package com.musala.atmopshere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musala.atmopshere.services.ModelService;

@RestController
public class ModelController {

	@Autowired
	ModelService modelService;

	@RequestMapping(value = "/models", method = RequestMethod.GET)
	public String getModels(
			@RequestParam(required = false, value = "filter") String filterValue) {
		String models = modelService.getModelsFromServer(filterValue);

		return models;
	}
}
