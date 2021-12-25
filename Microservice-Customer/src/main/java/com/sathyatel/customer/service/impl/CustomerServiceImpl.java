package com.sathyatel.customer.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathyatel.customer.entity.Customer;
import com.sathyatel.customer.model.CustomerDTO;
import com.sathyatel.customer.model.Login;
import com.sathyatel.customer.repository.CustomerRepository;
import com.sathyatel.customer.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {


	@Autowired
	CustomerRepository repository;

	public boolean saveNewCustomer(Customer customer) {
		boolean flag=repository.existsById(customer.getPhoneNo());
		if(flag==false)
		{
			repository.save(customer);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean loginCustomer(Login login) {
		Integer count=0;
		count=repository.verifyCustomer(login.getPhoneNo(),login.getPassword());
		if(count==1)
		{
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	public CustomerDTO getCustomerDetails(Long phoneNo) {


		Optional<Customer> opt=repository.findById(phoneNo);
		Customer customer=opt.get();
		CustomerDTO customerDto=new CustomerDTO();
		BeanUtils.copyProperties(customer,customerDto);
		return customerDto;

	}

	/*@Override
	public String changePlanId(String planId,Long phoneNo) {
		
		
		repository.changePlanId(planId, phoneNo);
		return null;
	}*/



}
