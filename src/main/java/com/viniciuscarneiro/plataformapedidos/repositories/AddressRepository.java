package com.viniciuscarneiro.plataformapedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viniciuscarneiro.plataformapedidos.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}	
