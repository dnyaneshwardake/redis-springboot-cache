package com.dnyanesh.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnyanesh.cache.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findUserById(Integer id);

}
