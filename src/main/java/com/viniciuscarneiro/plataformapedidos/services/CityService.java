package com.viniciuscarneiro.plataformapedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscarneiro.plataformapedidos.domain.City;
import com.viniciuscarneiro.plataformapedidos.repositories.CityRepository;
import com.viniciuscarneiro.plataformapedidos.services.exceptions.ObjectNotFoundException;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public City searchCity(Integer id) {

		Optional<City> city = cityRepository.findById(id);

		return city.orElseThrow(() -> new ObjectNotFoundException("Invalid or nonexistent id " + id + " parameter"));
	}

	public List<City> searchCity() {

		List<City> cities = cityRepository.findAll();

		return cities;
	}

	public City registerCity(City city) {

		return cityRepository.save(city);
	}
}
