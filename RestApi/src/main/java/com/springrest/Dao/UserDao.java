package com.springrest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	
}
