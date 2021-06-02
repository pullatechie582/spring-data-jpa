package com.javatechie.spring.data.jpa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.data.jpa.api.model.User;
import com.javatechie.spring.data.jpa.api.service.UserService;

@RestController
@RequestMapping ("spring-data-jpa")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping ("/getUsers")
	public List<User> getUsers(){
		return service.getUsers();	
	}
	
	@GetMapping ("getUsersByProfession/{profession}")
	public List<User> getUserByProfession(@PathVariable String profession){
		return service.getUsersByProfession(profession);
		
	}
	
	@GetMapping ("getCountByAge/{age}")
	public Long getCountByAge(@PathVariable Integer age) {
		return service.getCountByAge(age);
	}

	@DeleteMapping ("delete/{name}")
	public List<User> deleteUserByName(@PathVariable String name){
		return service.deleteUserByName(name);
	}
	
	@GetMapping ("getUsersByProfessionAndAge/{profession}/{age}")
	public List<User> getUsersByProfessionAndAge(@PathVariable String profession,@PathVariable Integer age){
		return service.getUsersByProfessionAndName(profession, age);
	}
	
	@GetMapping ("getRecordsCustomQuery")
	public List<User> getUsersCustomQuery(){
		return service.getUsersCustomQuery();
	}
}
