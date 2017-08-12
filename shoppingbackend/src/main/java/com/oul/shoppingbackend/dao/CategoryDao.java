package com.oul.shoppingbackend.dao;

import java.util.List;

import com.oul.shoppingbackend.dto.Category;

public interface CategoryDao {
	
	List<Category> list();
	
	Category get(int id);
	
}
