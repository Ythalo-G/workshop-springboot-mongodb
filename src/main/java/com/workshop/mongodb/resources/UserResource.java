package com.workshop.mongodb.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.mongodb.domain.User;
import com.workshop.mongodb.dto.UserDTO;
import com.workshop.mongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	//injetando o serviço
	@Autowired
	private UserService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	/** @GetMapping **/
	
	/*public ResponseEntity< List<User>> findAll(){
		User maria = new User("1", "Maria Silva", "Maria@gmail.com");
		User alex  = new User("2", "Alex Green", "Alex@gmail.com");
	    List<User> list = new ArrayList<>();
	    list.addAll(Arrays.asList(maria, alex));
	    return ResponseEntity.ok().body(list);
	
	}*/
	//pegar do banco
	public ResponseEntity< List<UserDTO>> findAll(){
	    List<User> list = service.findAll();
	    List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDto);
	
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
}
