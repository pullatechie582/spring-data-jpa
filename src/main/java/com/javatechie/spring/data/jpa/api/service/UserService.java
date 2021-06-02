package com.javatechie.spring.data.jpa.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.data.jpa.api.dao.UserRepository;
import com.javatechie.spring.data.jpa.api.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	  @PostConstruct
	  public void initDB() {
		  List<User> users= new ArrayList<User>(); 
		  users.add(new User(116, "pulls", "IT", 25)); users.add(new
	  User(117, "sri", "IT", 35)); users.add(new User(113, "padma", "TEACHER",
	  50)); users.add(new User(114, "saanvi", "LAB", 50)); users.add(new User(115,
	 "shannugaadu", "LAB", 50));
	 
	 repository.saveAll(users); }
	 
	public List<User> getUsers(){
		return repository.findAll();
		
	}
	
	public List<User> getUsersByProfession(String profession){
		return repository.findByProfession(profession);		
	}
	
	public Long getCountByAge(Integer age) {
		return repository.countByAge(age);		
	}
	
	@Transactional
	public List<User> deleteUserByName(String name){
		return repository.deleteByName(name);
	}
	
	public List<User> getUsersByProfessionAndName(String profession,Integer age){
		return repository.findByProfessionAndAge(profession, age);
	}
	public List<User> getUsersCustomQuery(){
		return repository.getUsersCustomQuery();	
	}
	}
