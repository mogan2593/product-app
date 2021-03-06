package com.chainsys.product.service;

import java.time.LocalDate;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public interface ProductService {
	Set<Product> findAll();
	Product findByName(String name)throws ProductNotFoundException;
	Product findById(int id) throws ProductNotFoundException;
	Product findBydate(LocalDate expirydate) throws ProductNotFoundException;
	void updateexpire(Product Product) throws ProductNotFoundException;
	void save(Product Product);

	void update(Product Product) throws ProductNotFoundException;

	void delete(int id) throws ProductNotFoundException;
    void delete(String name)throws ProductNotFoundException;
    void delete_date(LocalDate expiryDate) throws ProductNotFoundException;

}
