package com.sathyatel.plandetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathyatel.plandetails.entity.PlanDetails;
@Repository
public interface PlanDetailsRepository extends JpaRepository<PlanDetails,String> {
	

}
