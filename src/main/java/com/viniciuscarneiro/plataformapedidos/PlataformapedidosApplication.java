package com.viniciuscarneiro.plataformapedidos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciuscarneiro.plataformapedidos.domain.Address;
import com.viniciuscarneiro.plataformapedidos.domain.Category;
import com.viniciuscarneiro.plataformapedidos.domain.City;
import com.viniciuscarneiro.plataformapedidos.domain.Customer;
import com.viniciuscarneiro.plataformapedidos.domain.Product;
import com.viniciuscarneiro.plataformapedidos.domain.State;
import com.viniciuscarneiro.plataformapedidos.domain.enums.CustomerType;
import com.viniciuscarneiro.plataformapedidos.repositories.AddressRepository;
import com.viniciuscarneiro.plataformapedidos.repositories.CategoryRepository;
import com.viniciuscarneiro.plataformapedidos.repositories.CityRepository;
import com.viniciuscarneiro.plataformapedidos.repositories.CustomerRepository;
import com.viniciuscarneiro.plataformapedidos.repositories.ProductRepository;
import com.viniciuscarneiro.plataformapedidos.repositories.StateRepository;

@SpringBootApplication
public class PlataformapedidosApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
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
		
		State state1 = new State(null, "Goias");
		State state2 = new State(null, "Sao Paulo");
		
		City city1 = new City(null, "Campos Belos", state1);
		City city2 = new City(null, "São Paulo", state2);
		
		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2));
		
		Customer customer = new Customer(null, "Vinicius Santos", "viniciucarneiro@gmail.com", "70608146129", CustomerType.PESSOA_FISICA);
		customer.getPhones().addAll(Arrays.asList("62999263373", "6299955221"));
		
		Address address = new Address(null, "Rua Nossa Senhora da conceição", "SN", "QD L8 LT 13", "Setor Aeroporto", "73840000", customer, city1);
		
		customer.getAddresses().addAll(Arrays.asList(address));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2));
		customerRepository.saveAll(Arrays.asList(customer));
		addressRepository.saveAll(Arrays.asList(address));
	}
}
