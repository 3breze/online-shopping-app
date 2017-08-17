package com.oul.shoppingbackend.dao;

import java.util.List;

import com.oul.shoppingbackend.dto.Product;

public interface ProductDao {
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);  
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> listLatestActiveProducts(int count);
}
