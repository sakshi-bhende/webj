package com.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.Dao.UserDao;
import com.springrest.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao us;
	
	public List<User> getAllUser(){
		return us.findAll();
	}
	
	public User saveUser(User user) {
		return us.save(user);
	}
	
	public User getUserById(Integer Id) {
	  Optional<User>os =us.findById(Id);
	  if(os.isEmpty()) {
		  return null;
	  }
	  User u=os.get();
	  
	  
	  return u;
	}
	
	public User updateUser(Integer id,User user) {
		Optional<User>os=us.findById(id);
		if(os.isEmpty()) {
			return null;
		}
		User u=os.get();
		
		u.setId(u.getId());
		if(user.getFirstName()!=null) {
			u.setFirstName(user.getFirstName());
		}
		if(user.getLastName()!=null) {
			u.setLastName(user.getLastName());
		}
		if(user.getCity()!=null) {
			u.setCity(user.getCity());
		}
		
		us.save(u);
		
		return u;
		
	}
	
	public User deleteUser(Integer id) {
		Optional<User>u=us.findById(id);
		if(u.isEmpty()) {
			return null;
		}
		us.delete(u.get());
		return u.get();
	}
}
