package com.sathyatel.calldetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sathyatel.calldetails.dto.CallDetailsDTO;
import com.sathyatel.calldetails.service.ICallDetailsService;

@RestController
public class CallDetailsController {
	@Autowired
	private ICallDetailsService service;


	@GetMapping(value="/{phoneNumber}", produces="application/json")
	public List<CallDetailsDTO> getCallDetailsByPhoneNumber(@PathVariable("phoneNumber")Long calledBy)
	{
		List<CallDetailsDTO> list=service.getCallDetailsByPhoneNumber(calledBy);
		System.out.println(list);
		return list;
	}


}
