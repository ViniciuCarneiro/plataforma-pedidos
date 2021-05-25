package com.viniciuscarneiro.plataformapedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscarneiro.plataformapedidos.domain.Customer;
import com.viniciuscarneiro.plataformapedidos.repositories.CustomerRepository;
import com.viniciuscarneiro.plataformapedidos.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer searchCustomer(Integer id) {

		Optional<Customer> customer = customerRepository.findById(id);

		return customer.orElseThrow(() -> new ObjectNotFoundException("Invalid or nonexistent id " + id + " parameter"));
	}

	public List<Customer> searchCustomer() {

		List<Customer> customers = customerRepository.findAll();

		return customers;
	}
}
