package com.sathyatel.calldetails.service;

import java.util.List;

import com.sathyatel.calldetails.dto.CallDetailsDTO;

public interface ICallDetailsService {

	public List<CallDetailsDTO> getCallDetailsByPhoneNumber(Long calledBy);
	
}
