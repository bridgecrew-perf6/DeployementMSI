package com.sathyatel.friend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sathyatel.friend.entity.Friend;
@Repository
public interface FriendReposiotry extends JpaRepository<Friend,Integer> {

	List<Friend> findByPhoneNo(Long phoneNo);

	@Query(value="select count(*) from friend where phone_no=? and friend_no=?",nativeQuery=true)
	Integer verifyFriendNo(Long phoneNo,Long friendNo);


	//boolean existByPhoneNo(Long phoneNo);
}
