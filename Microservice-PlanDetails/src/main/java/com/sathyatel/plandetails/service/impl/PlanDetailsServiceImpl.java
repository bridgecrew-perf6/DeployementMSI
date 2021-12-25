package com.sathyatel.plandetails.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathyatel.plandetails.dto.PlanDetailsDTO;
import com.sathyatel.plandetails.entity.PlanDetails;
import com.sathyatel.plandetails.repository.PlanDetailsRepository;
import com.sathyatel.plandetails.service.IPlanDetailsService;
@Service
public class PlanDetailsServiceImpl implements IPlanDetailsService {

	@Autowired
	private PlanDetailsRepository repository;


	@Override
	public List<PlanDetailsDTO> getAllPlans() {
		List<PlanDetails> planDetailsList=repository.findAll();
		List<PlanDetailsDTO> planDetailsDtoList=new ArrayList<>();
		for(PlanDetails planDetails:planDetailsList)
		{
			PlanDetailsDTO dto=new PlanDetailsDTO();
			BeanUtils.copyProperties(planDetails,dto);
			planDetailsDtoList.add(dto);
		}
		return planDetailsDtoList;
	}


	public PlanDetailsDTO getPlanByPlanId(String planId) {

		Optional<PlanDetails> opt=repository.findById(planId);
		PlanDetails planDetails=opt.get();
		PlanDetailsDTO dto=new PlanDetailsDTO();
		BeanUtils.copyProperties(planDetails, dto);
		System.out.println(dto);
		return dto;
	}

}
