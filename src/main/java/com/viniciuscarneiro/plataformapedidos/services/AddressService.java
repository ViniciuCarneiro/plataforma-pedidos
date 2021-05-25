package com.viniciuscarneiro.plataformapedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscarneiro.plataformapedidos.domain.Address;
import com.viniciuscarneiro.plataformapedidos.repositories.AddressRepository;
import com.viniciuscarneiro.plataformapedidos.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public Address searchAddress(Integer id) {

		Optional<Address> address = addressRepository.findById(id);

		return address.orElseThrow(() -> new ObjectNotFoundException("Invalid or nonexistent id " + id + " parameter"));
	}

	public List<Address> searchAddress() {

		List<Address> address = addressRepository.findAll();

		return address;
	}
}
