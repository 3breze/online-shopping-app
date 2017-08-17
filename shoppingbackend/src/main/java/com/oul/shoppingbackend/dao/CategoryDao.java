package com.oul.shoppingbackend.dao;

import java.util.List;

import com.oul.shoppingbackend.dto.Category;

public interface CategoryDao {
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean delete(Category category);
	boolean update(Category category);
	
	
}
