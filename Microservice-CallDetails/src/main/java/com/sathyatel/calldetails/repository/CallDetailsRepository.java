package com.sathyatel.calldetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathyatel.calldetails.entity.CallDetails;
@Repository
public interface CallDetailsRepository extends JpaRepository<CallDetails,Long> {

	public List<CallDetails> findByCalledBy(Long calledBy);
}
