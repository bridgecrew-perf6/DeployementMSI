package com.sathyatel.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sathyatel.customer.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	
	@Query(value="select count(*) from Customer where phone_no=? and password=?",nativeQuery=true)
	Integer verifyCustomer(Long phone,String password);

	/*@Query(value="select count(*) from Customer where phone_no=?",nativeQuery=true)
	Integer verifyCustomerByPhoneNumber(Long phoneNo);
*/
	
	/*@Query(value="update customer set plan_id=? where phone_no=?",nativeQuery=true)
	public Integer changePlanId(String planId,Long phoneNo);*/
}
