package com.cdac.backend.services;

import java.util.List;

import com.cdac.backend.dto.UsersDTO;

public interface UserService {
	public boolean save(UsersDTO dto);
	public UsersDTO getByUsername(String uName);
	public List<UsersDTO> getAllUsers();
}
