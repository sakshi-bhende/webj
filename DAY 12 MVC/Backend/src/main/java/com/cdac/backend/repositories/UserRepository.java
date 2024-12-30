package com.cdac.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.backend.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users,String> {

}
