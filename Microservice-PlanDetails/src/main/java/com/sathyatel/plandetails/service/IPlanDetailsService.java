package com.sathyatel.plandetails.service;

import java.util.List;

import com.sathyatel.plandetails.dto.PlanDetailsDTO;

public interface IPlanDetailsService {

	public List<PlanDetailsDTO> getAllPlans();
	public  PlanDetailsDTO getPlanByPlanId(String planId);
}
