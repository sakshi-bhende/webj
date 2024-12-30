package com.cdac.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.backend.dto.UsersDTO;
import com.cdac.backend.entity.Users;
import com.cdac.backend.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean save(UsersDTO dto) {
		Users userEntity = new Users();
		BeanUtils.copyProperties(dto, userEntity);
		userRepository.save(userEntity);
		return true;
	}

	@Override
	public UsersDTO getByUsername(String uName) {
		Optional<Users> userEntity = userRepository.findById(uName);
		if(userEntity.isPresent()) {
			UsersDTO dto = new UsersDTO();
			BeanUtils.copyProperties(userEntity.get(),dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<UsersDTO> getAllUsers() {
		
		return null;
	}

}
