package com.sathyatel.plandetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sathyatel.plandetails.dto.PlanDetailsDTO;
import com.sathyatel.plandetails.service.IPlanDetailsService;

@Controller
@ResponseBody
public class PlanDetailsRestController {
    @Autowired
	 private IPlanDetailsService service;
	
    @GetMapping(value="/allPlans", produces="application/json")
    public List<PlanDetailsDTO> getAllPlans()
    {
    	return service.getAllPlans();
    }
    
    @GetMapping(value="/{planId}",produces="application/json")
    public PlanDetailsDTO getPlanByPlanId(@PathVariable("planId")String planId)
    {
    	
    	return service.getPlanByPlanId(planId);
    }
    
    @GetMapping(value="/changePlan", produces="application/json")
    public List<PlanDetailsDTO> listPlans()
    {
    	return service.getAllPlans();
    }
}
