package com.viniciuscarneiro.plataformapedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuscarneiro.plataformapedidos.domain.City;
import com.viniciuscarneiro.plataformapedidos.services.CityService;

@RestController
@RequestMapping(value="/cities")
public class CityResource {

	@Autowired
	private CityService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		City city = service.searchCity(id);
		
		return ResponseEntity.ok(city);	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		
		List<City> cities = service.searchCity();
		
		return ResponseEntity.ok(cities);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody City city){
		
		City newCity  = service.registerCity(city);
		newCity.setResponseMessage("Cidade cadastrada com sucesso!");
		
	    return ResponseEntity.ok().body(newCity);
	}
}
