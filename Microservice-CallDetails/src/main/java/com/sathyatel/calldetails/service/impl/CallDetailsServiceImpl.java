package com.sathyatel.calldetails.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathyatel.calldetails.dto.CallDetailsDTO;
import com.sathyatel.calldetails.entity.CallDetails;
import com.sathyatel.calldetails.repository.CallDetailsRepository;
import com.sathyatel.calldetails.service.ICallDetailsService;
@Service
public class CallDetailsServiceImpl implements ICallDetailsService {
	
	
	
	@Autowired
	CallDetailsRepository repository;


	@Override
	public List<CallDetailsDTO> getCallDetailsByPhoneNumber(Long calledBy) {
		
		
		List<CallDetails> callDetailsList=repository.findByCalledBy(calledBy);

		List<CallDetailsDTO> callDetailsDtoList=new ArrayList<>();

		for(CallDetails callDetails:callDetailsList)
		{
			CallDetailsDTO dto=new CallDetailsDTO();
			BeanUtils.copyProperties(callDetails,dto);
			callDetailsDtoList.add(dto);


		}
		return callDetailsDtoList;
		
		
		
		
		
		
	}

}
