package com.workshop.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.mongodb.Repository.UserRepository;
import com.workshop.mongodb.domain.User;
import com.workshop.mongodb.services.Exceptions.ObjectNotFoundException;

@Service
public class UserService {
     //instancia do objeto repository
	//injeção de dependencia automatico
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}
