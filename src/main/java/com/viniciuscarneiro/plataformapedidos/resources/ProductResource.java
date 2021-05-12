package com.viniciuscarneiro.plataformapedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuscarneiro.plataformapedidos.domain.Product;
import com.viniciuscarneiro.plataformapedidos.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Product product = service.searchProduct(id);
		
		return ResponseEntity.ok(product);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findById() {
		
		List<Product> products = service.searchProduct();
		
		return ResponseEntity.ok(products);
	}
}
