package com.example.ShriTailors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShriTailors.model.Customer;
import com.example.ShriTailors.repository.CustomerRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody Customer customer)
	{
		
		String password=customer.getPassword();
		String encryptPassowrd=passwordEncoder.encode(password);
		customer.setPassword(encryptPassowrd);
		customerRepository.save(customer);
		return "user addes successfully";
	}
}
