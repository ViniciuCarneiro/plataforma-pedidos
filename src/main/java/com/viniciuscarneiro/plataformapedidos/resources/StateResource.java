package com.viniciuscarneiro.plataformapedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuscarneiro.plataformapedidos.domain.State;
import com.viniciuscarneiro.plataformapedidos.services.StateService;


@RestController
@RequestMapping(value = "/states")
public class StateResource {

	@Autowired
	private StateService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {

		State state = service.searchState(id);

		return ResponseEntity.ok(state);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> find() {

		List<State> states = service.searchState();

		return ResponseEntity.ok(states);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody State state) {

		State newState = service.registerState(state);

		return ResponseEntity.ok().body(newState);
	}
}

