package com.sathyatel.friend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathyatel.friend.entity.Friend;
import com.sathyatel.friend.repository.FriendReposiotry;
import com.sathyatel.friend.service.IFriendService;
@Service
public class FriendServiceImpl implements IFriendService {
	
	@Autowired
	FriendReposiotry repository;

	@Override
	public String addFriendService(Friend friend) {
		Integer count=0;
		System.out.println("hiiiii from service impl");
		count=repository.verifyFriendNo(friend.getPhoneNo(), friend.getFriendNo());
		System.out.println("hiiiii from after service impl");
		if(count==0)
		{
			repository.save(friend);
			return "Friend is added";
		}
		else {

			return "Friend Number Already Exist";

		}	

	}

	@Override
	public List<Long> getFriendNoService(Long phoneNo) {
      /* boolean flag= repository.existByPhoneNo(phoneNo);   
       System.out.println(flag);*/
		List<Friend> friendList1=repository.findByPhoneNo(phoneNo);
		
		List<Long> friendNoList=new ArrayList<>();
		System.out.println(friendList1);
		for(Friend friend:friendList1)
		{
			Long friendNo=friend.getFriendNo();
			System.out.println("inside for loop");
			System.out.println(friendNo);
			friendNoList.add(friendNo);
		}
		//System.out.println("");
		return friendNoList;
	}

}
