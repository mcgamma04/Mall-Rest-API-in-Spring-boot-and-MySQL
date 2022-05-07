package com.stringcodeltd.productrestapi.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stringcodeltd.productrestapi.entities.Product;
import com.stringcodeltd.productrestapi.model.ProductRepository;


@RestController
public class ProductController {
	@Autowired
	ProductRepository repository;
	@Value("${uploadDir}")
	private String UPLOAD_DIR;

	
	@RequestMapping(value= "/product/",method = RequestMethod.GET)
	public List<Product> getaLLProduct(){
		return repository.findAll();
		
	}
	
  @RequestMapping(value="/product/{id}",method =  RequestMethod.GET)
  
  public Product getProduct(@PathVariable("id") int id) {
	  return repository.findById(id).get();
	  
  }
  
  @RequestMapping(value="/product/",method= RequestMethod.POST)
  public Product createProduct(@Valid @RequestBody Product product) {
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
  
  @PostMapping("/upload")
  public boolean upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
	  file.transferTo(new File(UPLOAD_DIR+file.getOriginalFilename()));
	  return true;
  }
  
  @GetMapping("/download/{filename}")
  public ResponseEntity<byte[]>download(@PathVariable("filename") String filename) throws IOException{
	  byte[] filedata = Files.readAllBytes(new File(UPLOAD_DIR+filename).toPath());
	 HttpHeaders header = new  HttpHeaders();
	 header.setContentType(MediaType.IMAGE_JPEG);
	 return new ResponseEntity<byte[]>(filedata,header,HttpStatus.OK);
  }
  
  
  
  
  
  
  
  
  
  
  
}
