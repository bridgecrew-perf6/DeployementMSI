package com.sathyatel.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.sathyatel.customer.model.PlanDTO;

@Service
public class CustomerCircuitService {

	@Autowired
	RestTemplate restTemplate;

	String FRIEND_URL = "http://FriendMS/FriendApi/friends/{phoneNo}";
	String PLAN_URL="http://PLANDETAILSMS/PlanDetailsApi/{planId}";

	@HystrixCommand(fallbackMethod="getFriendsFallback")
	public List<Long> getFriends(Long phoneNo)
	{
		System.out.println(restTemplate.getForObject(FRIEND_URL,List.class,phoneNo));
		return restTemplate.getForObject(FRIEND_URL,List.class,phoneNo);
	}


	public List<Long> getFriendsFallback(Long phoneNo)
	{
		System.out.println("from fallback method");
		return new ArrayList<Long>();
	}
	public PlanDTO getPlanData(String planId)
	{
		return restTemplate.getForObject(PLAN_URL,PlanDTO.class,planId);
	}
/*	public Future<PlanDTO> getPlanData(String planId)
	{
		System.out.println("from getplandata():"+planId);
		return new AsyncResult<PlanDTO>(){
		
			public PlanDTO invoke() {
				 System.out.println("hiiiii");
				return restTemplate.getForObject(PLAN_URL,PlanDTO.class,planId);
			}
		};
	}
*/}
