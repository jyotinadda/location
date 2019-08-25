package com.example.ShriTailors.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShriTailors.exception.ResourceNotFoundException;
import com.example.ShriTailors.model.Customer;
import com.example.ShriTailors.repository.CustomerRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
class CustomerController
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	@ApiOperation(value="Finds all customers",
	notes="gets all customers present",
	response=Customer.class)
	public Page<Customer> getCustomers(Pageable pageable)
	{
		return customerRepository.findAll(pageable);
	}
	
	@GetMapping("/customers/{custId}")
	public Customer getCustomersById(@ApiParam(value="ID value for the contact you neex=d to retrieve") @PathVariable UUID custId)
	{
		return customerRepository.findByCustId(custId);
		
	}

	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer)
	{
		return customerRepository.save(customer);
	}
	
    @PutMapping("/customers/{custId}")
    public Customer updateCustomer(@PathVariable UUID custId,
                                   @Valid @RequestBody Customer customerRequest) {
        return customerRepository.findById(custId)
                .map(question -> {
                    question.setCustName(customerRequest.getCustName());
                    question.setCustMobile(customerRequest.getCustMobile());
                    return customerRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + custId));
    }


    @DeleteMapping("/customers/{custId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable UUID custId) {
        return customerRepository.findById(custId)
                .map(customer -> {
                	customerRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + custId));
    }
    
    
}