package com.sathyatel.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sathyatel.friend.entity.Friend;
import com.sathyatel.friend.service.IFriendService;

@RestController
public class FriendRestController {

	@Autowired
	private IFriendService service;

	@PostMapping(value="/addFriend" )
	public String addFriend(@RequestBody Friend friend)
	{
		String msg=service.addFriendService(friend);
		return msg;
	}


	@GetMapping(value="/friends/{phoneNo}")
	public List<Long> getListFriendNoByPhoneNo(@PathVariable Long phoneNo)
	{
		System.out.println("from Friend");

		System.out.println("from:"+phoneNo);
		System.out.println("from calling service:"+service.getFriendNoService(phoneNo));
		return service.getFriendNoService(phoneNo);

	}

}
