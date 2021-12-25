package com.sathyatel.customer.model;

public class ChangePlan {
private Long phoneNo;
private String planId;
public Long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(Long phoneNo) {
	this.phoneNo = phoneNo;
}
public String getPlanId() {
	return planId;
}
public void setPlanId(String planId) {
	this.planId = planId;
}
@Override
public String toString() {
	return "ChangePlan [phoneNo=" + phoneNo + ", planId=" + planId + "]";
}


	
	
}
