package com.chainsys.product.dao;

import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();
	Product findByName(String name);
	Product findById(int id);
	void updateexpire(Product Product);
	void save(Product product);
    void delete(String name);
	void update(Product product);

	void delete(int id);
}
