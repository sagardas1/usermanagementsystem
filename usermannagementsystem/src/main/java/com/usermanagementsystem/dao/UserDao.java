package com.usermanagementsystem.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usermanagementsystem.entity.RegistrationEntity;

@Repository
public interface UserDao extends JpaRepository<RegistrationEntity, Long>{

	
	@Query(value="select * from RegistrationEntity where email =:emailId",nativeQuery = true)
	List<RegistrationEntity> getUser(@Param("emailId")String email);

	@Transactional
	@Query(value="update RegistrationEntity set password=:newPassword where email=:email",nativeQuery = true)
	void updateUser(String email, String newPassword);

	@Transactional
	@Query(value="select * from RegistrationEntity",nativeQuery = true)
	List<RegistrationEntity> getAllUser();
	@Transactional
	@Query(value="update RegistrationEntity set dateOfBirth=:dateOfBirth,firstName=:firstName,lastName=:lastName,userName=:userName where email=:email",nativeQuery = true)
	void updaterecord(String dateOfBirth, String firstName, String lastName, String userName,String email);

}
