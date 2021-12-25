package com.sathyatel.customer.service;

import com.sathyatel.customer.entity.Customer;
import com.sathyatel.customer.model.CustomerDTO;
import com.sathyatel.customer.model.Login;

public interface ICustomerService {

	boolean saveNewCustomer(Customer customer);
	
	boolean loginCustomer(Login login);

	CustomerDTO getCustomerDetails(Long phoneNo);
	/*String changePlanId(String planId,Long phoneNo);*/
	
}
