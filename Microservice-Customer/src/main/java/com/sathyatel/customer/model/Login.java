package com.sathyatel.customer.model;

public class Login {

	private Long phoneNo;
	private String password;
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [phoneNo=" + phoneNo + ", password=" + password + "]";
	}



}
