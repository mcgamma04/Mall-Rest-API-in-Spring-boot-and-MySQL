package com.stringcodeltd.productrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stringcodeltd.productrestapi.entities.Product;
import com.stringcodeltd.productrestapi.model.ProductRepository;


@RestController
public class ProductController {
	@Autowired
	ProductRepository repository;

	
	@RequestMapping(value= "/product/",method = RequestMethod.GET)
	public List<Product> getaLLProduct(){
		return repository.findAll();
		
	}
	
  @RequestMapping(value="/product/{id}",method =  RequestMethod.GET)
  
  public Product getProduct(@PathVariable("id") int id) {
	  return repository.findById(id).get();
	  
  }
  
  @RequestMapping(value="/product/",method= RequestMethod.POST)
  public Product createProduct(@RequestBody Product product) {
	  return repository.save(product);
  }
  
  @RequestMapping(value="/product/", method =  RequestMethod.PUT)
  public Product updateProduct(@RequestBody Product product) {
	  return repository.save(product);
  }
  
  @RequestMapping(value="/product/{id}",method = RequestMethod.DELETE)
  public void deleteProduct(@PathVariable("id") int id) {
	  repository.deleteById(id); 
  }
  
}
