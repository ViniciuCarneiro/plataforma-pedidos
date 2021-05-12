package com.viniciuscarneiro.plataformapedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniciuscarneiro.plataformapedidos.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}