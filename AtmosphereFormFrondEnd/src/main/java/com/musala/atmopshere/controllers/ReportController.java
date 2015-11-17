package com.musala.atmopshere.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.musala.atmopshere.services.ReportService;

@RestController
public class ReportController {

	@Autowired
	ReportService reportService;
	
	@RequestMapping(value="/report/save",  method = RequestMethod.POST)
	public  @ResponseBody ResponseEntity<String> saveReportToDataBase(HttpServletRequest request, HttpServletResponse response){
		System.out.println("!!!!! call service !!!!");	
		String result = request.getParameter("report");
		System.out.println(">>>>>>>>>>>>>>>>>>> REPORT" + result);
		ResponseEntity<String> report = reportService.postReport(result);
		return report;
	}
	
	
	@RequestMapping(value = "/reports", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String getReports() {

		return "hello";
	}
}
