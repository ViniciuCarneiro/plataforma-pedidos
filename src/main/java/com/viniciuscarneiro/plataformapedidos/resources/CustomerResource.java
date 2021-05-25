package com.viniciuscarneiro.plataformapedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuscarneiro.plataformapedidos.domain.Customer;
import com.viniciuscarneiro.plataformapedidos.services.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {

	@Autowired
	private CustomerService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {

		Customer customer = service.searchCustomer(id);

		return ResponseEntity.ok(customer);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> find() {

		List<Customer> customers = service.searchCustomer();

		return ResponseEntity.ok(customers);
	}
}	
