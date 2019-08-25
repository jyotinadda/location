package com.example.ShriTailors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ShriTailors.model.Customer;
import java.util.UUID;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID>
{
	Customer findByCustId(UUID custId);
}