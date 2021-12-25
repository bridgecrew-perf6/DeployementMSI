package com.sathyatel.customer.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sathyatel.customer.entity.Customer;
import com.sathyatel.customer.model.ChangePlan;
import com.sathyatel.customer.model.CustomerDTO;
import com.sathyatel.customer.model.Login;
import com.sathyatel.customer.model.PlanDTO;
import com.sathyatel.customer.repository.CustomerRepository;
import com.sathyatel.customer.service.ICustomerService;

@RestController
@RibbonClient(name="custribbon")
public class CustomerRestController {

	@Autowired
	CustomerCircuitService circuit;

	@Autowired
	private ICustomerService service;

	@Autowired
	private RestTemplate restTemplate;


	@Autowired
	private CustomerRepository repository;

	@PostMapping("/register")
	public boolean registerNewCustomer(@RequestBody Customer customer)
	{

		return service.saveNewCustomer(customer);
	}

	@PostMapping(value="/login")
	public boolean loginCustomer(@RequestBody Login login)
	{
		System.out.println(login);
		/*Integer count=0;
		count=service.loginCustomer(login);
		return count;*/
		return service.loginCustomer(login);
	}

	/*@GetMapping(value="/profile/{phoneNo}",produces="application/json")
	public ResponseEntity getCustomerProfile(@PathVariable Long phoneNo)
	{
		String POST_URL_1="http://localhost:4444/PlanDetailsApi/plan-199";
		String POST_URL_2 = "http://localhost:5577/FriendApi/friends/9893787401";
                  Integer n=repository.verifyCustomerByPhoneNumber(phoneNo);
                  if(n==1)
                  {
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<PlanDTO> responseEntity= restTemplate.exchange(POST_URL_1,HttpMethod.GET,null,PlanDTO.class);
		PlanDTO planDTO=responseEntity.getBody();
		System.out.println(planDTO);
		ResponseEntity<List> responseEntity1= restTemplate.exchange(POST_URL_2,HttpMethod.GET,null,List.class);
		List friendNoList=responseEntity1.getBody();
		CustomerDTO customerDTO=new CustomerDTO();


		customerDTO.setFriends(friendNoList);
		customerDTO.setCurrentPlan(planDTO);
		Customer customer=service.getCustomerDetails(phoneNo);
		customerDTO.setPhoneNo(customer.getPhoneNo());
		customerDTO.setName(customer.getName());
		customerDTO.setPlanId(customer.getPlanId());
		ResponseEntity<CustomerDTO> rs=new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.OK);
		return rs;
                  }
                  else {
                	  ResponseEntity<CustomerDTO> customerDT=new ResponseEntity<CustomerDTO>();
                	  return 
                  }
	}
	 */


	@GetMapping(value="/profile/{phoneNo}",produces="application/json")
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) 
	{

		/*String PLAN_URL="http://PLANDETAILSMS/PlanDetailsApi/{planId}";
		String FRIEND_URL = "http://FRIENDMS/FriendApi/friends/{phoneNo}";*/
		CustomerDTO customerDto=service.getCustomerDetails(phoneNo);
		/*PlanDTO planDto=restTemplate.getForObject(PLAN_URL,PlanDTO.class,customerDto.getPlanId());
		customerDto.setCurrentPlan(planDto);*/
		/*List friendsContactNumber=restTemplate.getForObject(FRIEND_URL,List.class,customerDto.getPhoneNo());
		customerDto.setFriends(friendsContactNumber);
		 */
		/*PlanDTO planDto=circuit.getPlanData(customerDto.getPlanId());
		customerDto.setCurrentPlan(planDto);*/
		Long x=System.currentTimeMillis();
		List friendsContactNumber=circuit.getFriends(phoneNo);
		PlanDTO future=circuit.getPlanData(customerDto.getPlanId());
		/*try {
			
			System.out.println("from try block");
			customerDto.setCurrentPlan(future.get());
		}catch(Exception e)
		{
			e.printStackTrace();
		}*/
      
		customerDto.setCurrentPlan(future);
		Long y=System.currentTimeMillis();
		System.out.println("the Time Taken in Milli:"+(y-x));
		customerDto.setFriends(friendsContactNumber);
		System.out.println("from customerDto:"+customerDto);
		return customerDto;






	}

	@GetMapping(value="/changePlanId/{phoneNo}",produces="application/json")
	public CustomerDTO changePlanId(@PathVariable Long phoneNo)
	{

		String PLAN_URL="http://localhost:4444/PlanDetailsApi/{planId}";
		//String FRIEND_URL = "http://localhost:5577/FriendApi/friends/{phoneNo}";
		CustomerDTO customerDto=service.getCustomerDetails(phoneNo);
		PlanDTO planDto=restTemplate.getForObject(PLAN_URL,PlanDTO.class,customerDto.getPlanId());
		customerDto.setCurrentPlan(planDto);
		//List friendsContactNumber=restTemplate.getForObject(FRIEND_URL,List.class,customerDto.getPhoneNo());
		//customerDto.setFriends(friendsContactNumber);
		return customerDto;

	}

	@PostMapping("/changePlan")
	public CustomerDTO changePlanId(@RequestBody ChangePlan changePlan)
	{
		Optional<Customer> opt=repository.findById(changePlan.getPhoneNo());
		Customer customer=opt.get();
		customer.setPlanId(changePlan.getPlanId());
		customer=repository.saveAndFlush(customer);
		CustomerDTO customerDto=new CustomerDTO();
		BeanUtils.copyProperties(customer, customerDto);
		return customerDto;

	}












}
