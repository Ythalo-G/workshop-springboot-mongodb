package com.workshop.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.mongodb.Repository.UserRepository;
import com.workshop.mongodb.domain.User;

@Service
public class UserService {
     //instancia do objeto repository
	//injeção de dependencia automatico
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
