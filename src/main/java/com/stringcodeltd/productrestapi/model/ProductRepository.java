package com.stringcodeltd.productrestapi.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stringcodeltd.productrestapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
