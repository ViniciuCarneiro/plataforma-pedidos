package com.viniciuscarneiro.plataformapedidos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuscarneiro.plataformapedidos.domain.Category;

@RestController
@RequestMapping(value="/categorys")
public class CategoryResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listCategorys() {
		
		Category category1 = new Category(1, "Informática");
		Category category2 = new Category(2, "Escritório");
		
		List<Category> list = new ArrayList<>();
		list.add(category1);
		list.add(category2);
		
		return list;
	}
}
