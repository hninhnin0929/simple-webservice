package com.webservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.webservice.modal.User;
import com.webservice.repository.UserRepository;


@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public void saveMyUser(User user){
		userRepository.save(user);
	}
	
	public List<User> showAllUsers(){
		List<User> users = new ArrayList<User>();
		for(User user:userRepository.findAll()){
			users.add(user);
		}
		return users;		
	}
	
	public void deleteMyUser(int id){
		userRepository.deleteById(id);
	}
	
	public Optional<User> editUser(int id){
		return userRepository.findById(id);
	}
	
	public User findByUsernameAndPassword(String username, String password){
		
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
