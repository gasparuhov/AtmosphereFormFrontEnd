package com.musala.atmopshere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musala.atmopshere.services.GetModelsFromUserService;

@RestController
public class GetModelsFromUserController {

	@Autowired
	GetModelsFromUserService getModelsFromUserService;
	
	@RequestMapping(value = "/reports/modelNumbers", method = RequestMethod.GET)
	public String getModelsFromUser(@RequestParam(required = true, value = "author") String author){
		
		String modelsFromUser = getModelsFromUserService.getModelsFomUserFromServer(author);
		return modelsFromUser;
	}
}
