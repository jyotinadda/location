package com.jyoti.customer.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.jyoti.customer.dal.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}
