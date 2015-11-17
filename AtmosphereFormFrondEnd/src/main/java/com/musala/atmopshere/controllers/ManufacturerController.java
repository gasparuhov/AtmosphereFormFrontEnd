package com.musala.atmopshere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musala.atmopshere.services.ManufacturerService;

@RestController

public class ManufacturerController {

	@Autowired
	private ManufacturerService manufacturerService;
	
	@RequestMapping(value = "/manufacturers", method = RequestMethod.GET)

	public String listManufacturers() {
		String manufacturers = manufacturerService.getManufacturerFromServer();
		return manufacturers;

	}
	
}
