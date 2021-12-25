package com.sathyatel.friend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	
	private Long friendNo;
	private Long phoneNo;


	public Friend() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Long getFriendNo() {
		return friendNo;
	}
	public void setFriendNo(Long friendNo) {
		this.friendNo = friendNo;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", phoneNo=" + phoneNo + ", friendNo=" + friendNo + "]";
	}




}
