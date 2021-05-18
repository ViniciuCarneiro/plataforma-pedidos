package com.viniciuscarneiro.plataformapedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscarneiro.plataformapedidos.domain.State;
import com.viniciuscarneiro.plataformapedidos.repositories.StateRepository;
import com.viniciuscarneiro.plataformapedidos.services.exceptions.ObjectNotFoundException;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public State searchState(Integer id) {

		Optional<State> state = stateRepository.findById(id);

		return state.orElseThrow(() -> new ObjectNotFoundException("Invalid or nonexistent id " + id + " parameter"));
	}

	public List<State> searchState() {

		List<State> states = stateRepository.findAll();

		return states;
	}

	public State registerState(State state) {

		return stateRepository.save(state);
	}
}