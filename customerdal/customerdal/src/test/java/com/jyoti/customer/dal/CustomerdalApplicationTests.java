package com.jyoti.customer.dal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jyoti.customer.dal.entities.Customer;
import com.jyoti.customer.dal.repos.CustomerRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerdalApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("abc");
		customer.setName("jyoti");
		
		customerRepository.save(customer);
	}

	@Test
	public void testFindCustomerById()
	{
		Customer customer=customerRepository.findById(1L).get();
		System.out.println(customer);
	}
	
	@Test
	public void testUpdateCustomer()
	{
		Customer customer=customerRepository.findById(1L).get();
		customer.setEmail("abc@gmail.com");
		customerRepository.save(customer);
	}
	
	@Test
	public void deleteCustomer()
	{
		customerRepository.deleteById(2L);;
	}
}
