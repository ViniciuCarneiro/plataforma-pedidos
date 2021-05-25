package com.viniciuscarneiro.plataformapedidos.domain.enums;

public enum CustomerType {

	PESSOA_FISICA(0, "Pessoa Fisica"),
	PESSOA_JURIDICA1(1, "Pessoa Juridica");
	
	private int id;
	private String description;
	
	private CustomerType(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescriptiom() {
		return description;
	}
	
	public static CustomerType toEnum(Integer id) {
		
		if(id == null) {
			return null;
		}
	
		for(CustomerType customer : CustomerType.values()) {
			if(id.equals(customer.getId())) {
				return customer;
			}
		}
		
		throw new IllegalArgumentException("Id invalid " + id );
	}
}
