package com.viniciuscarneiro.plataformapedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuscarneiro.plataformapedidos.domain.Address;
import com.viniciuscarneiro.plataformapedidos.services.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {

	@Autowired
	private AddressService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {

		Address address= service.searchAddress(id);

		return ResponseEntity.ok(address);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> find() {

		List<Address> address = service.searchAddress();

		return ResponseEntity.ok(address);
	}
}	
