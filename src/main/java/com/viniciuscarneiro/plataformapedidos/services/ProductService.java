package com.viniciuscarneiro.plataformapedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscarneiro.plataformapedidos.domain.Product;
import com.viniciuscarneiro.plataformapedidos.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product searchProduct(Integer id) {
		
		Optional<Product> product = productRepository.findById(id);
		
		return product.orElse(null);
	}	
	
	public List<Product> searchProduct() {
			
		List<Product> products = productRepository.findAll();
		
		return products;
	}
}
