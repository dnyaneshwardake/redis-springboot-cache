package com.dnyanesh.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnyanesh.cache.model.User;
import com.dnyanesh.cache.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping("/{id}")
	@Cacheable(value = "users", key = "#id")
	public User getUsetById(@PathVariable Integer id) {
		System.out.println("Employee fetching from database:: " + id);
		return repository.findById(id).orElseThrow(() -> new ResouceNotFoundException("User not found " + id));
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return repository.save(user);
	}

	@PutMapping("/{id}")
	@CachePut(value = "users", key = "#id")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
		return repository.save(user);
	}

	@DeleteMapping("{id}")
	@CacheEvict(value = "users", allEntries = true)
	public String deleteUser(@PathVariable Integer id) {
		// User user = repository.findUserById(id);
		repository.deleteById(id);
		return "success";
	}

}
