package com.chainsys.product.service;

import java.time.LocalDate;
import java.util.Set;

import com.chainsys.product.dao.ProductDAO;
import com.chainsys.product.dao.ProductDAOImpl;
import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public class ProductServiceImpl implements ProductService {
	private static ProductDAO dao;

	public ProductServiceImpl() {
		dao = new ProductDAOImpl();
	}

	@Override
	public Set<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			return Product;
		}
	}

	@Override
	public void save(Product Product) {
		dao.save(Product);

	}

	@Override
	public void update(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.update(Product);
		}

	}

	@Override
	public void delete(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(id);
		}
	}
	@Override
	public Product findByName(String name)throws ProductNotFoundException{
		Product product = dao.findByName(name);
		if(product == null) {
			throw new ProductNotFoundException("Product Name Not Found");
		}
		else {
			return product;
		}
	}
	@Override
	public void updateexpire(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.update(Product);
		}

	}
	@Override
	public void delete(String name) throws ProductNotFoundException {
		Product Product = dao.findByName(name);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(name);
		}
	}
	@Override
	public Product findBydate(LocalDate date)throws ProductNotFoundException{
		Product product = dao.findBydate(date);
		if(product == null) {
			throw new ProductNotFoundException("Product Name Not Found");
		}
		else {
			return product;
		}
	}
	@Override
	public void delete_date(LocalDate expiryDate) throws ProductNotFoundException {
		Product product = dao.findBydate(expiryDate);
		if (product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete_date(expiryDate);
		}
	}
	
}
