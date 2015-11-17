package com.musala.atmopshere.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.util.JSONPObject;

public interface ReportService {

	public   ResponseEntity<String> postReport(String report);

}
