package com.chainsys.product.dao;

import java.time.LocalDate;
import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();
	Product findByName(String name);
	Product findById(int id);
	Product findBydate(LocalDate expirydate);
	void updateexpire(Product Product);
	void save(Product product);
    void delete(String name);
	void update(Product product);
	void delete_date(LocalDate expiryDate);
	void delete(int id);
}
