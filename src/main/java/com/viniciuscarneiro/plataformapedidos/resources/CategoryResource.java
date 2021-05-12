package com.viniciuscarneiro.plataformapedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuscarneiro.plataformapedidos.domain.Category;
import com.viniciuscarneiro.plataformapedidos.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Category category = service.searchCategory(id);
		
		return ResponseEntity.ok(category);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		
		List<Category> categories = service.searchCategory();
		
		return ResponseEntity.ok(categories);
	}
}

