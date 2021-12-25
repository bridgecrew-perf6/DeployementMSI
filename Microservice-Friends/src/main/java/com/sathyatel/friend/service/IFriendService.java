package com.sathyatel.friend.service;

import java.util.List;

import com.sathyatel.friend.entity.Friend;
public interface IFriendService {
	List<Long> getFriendNoService(Long phoneNo);
	String addFriendService(Friend friendNo);

}
