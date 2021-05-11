package com.viniciuscarneiro.plataformapedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscarneiro.plataformapedidos.domain.Category;
import com.viniciuscarneiro.plataformapedidos.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category searchCategory(Integer id) {
		
		Optional<Category> category = categoryRepository.findById(id);
		
		return category.orElse(null);
	}	
	
	public List<Category> searchCategory() {
			
		List<Category> categories = categoryRepository.findAll();
		
		return categories;
	}	
}
