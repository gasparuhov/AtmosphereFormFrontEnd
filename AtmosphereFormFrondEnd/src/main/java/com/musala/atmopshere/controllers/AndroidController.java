package com.musala.atmopshere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.musala.atmopshere.services.AndroidService;;

@RestController
public class AndroidController {

	@Autowired
	private AndroidService androidService;

	@RequestMapping(value = "/androids", method = RequestMethod.GET)
	@ResponseBody
	public String listAndroids() {

		String androids = androidService.getAndroidsFromServer();
		return androids;

	}
}
