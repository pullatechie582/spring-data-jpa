package com.javatechie.spring.data.jpa.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.javatechie.spring.data.jpa.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByProfession(String profession);
	public Long countByAge(int age);
	public List<User> deleteByName(String name);
	public List<User> findByProfessionAndAge(String profession,Integer age);
	@Modifying
	@Query ("select u from User u")
	public List<User> getUsersCustomQuery();
}
