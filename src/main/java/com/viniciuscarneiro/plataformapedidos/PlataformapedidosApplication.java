package com.viniciuscarneiro.plataformapedidos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciuscarneiro.plataformapedidos.domain.Category;
import com.viniciuscarneiro.plataformapedidos.domain.Product;
import com.viniciuscarneiro.plataformapedidos.repositories.CategoryRepository;
import com.viniciuscarneiro.plataformapedidos.repositories.ProductRepository;

@SpringBootApplication
public class PlataformapedidosApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PlataformapedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informatica");
		Category cat2 = new Category(null, "Escritorio");
		
		Product prod1 = new Product(null, "Computador", 2.000);
		Product prod2 = new Product(null, "Impressora", 800.0);
		Product prod3 = new Product(null, "Mouse", 100.0);
		
		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));
		
		prod1.getCategories().add(cat1);
		prod2.getCategories().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategories().add(cat1);
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
	}
}
