package com.oul.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oul.shoppingbackend.dao.CategoryDao;
import com.oul.shoppingbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("Some random ass description ");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Some new random ass description ");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Some new new random ass description ");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category c:categories){
			if(c.getId() == id) return c;
		}
		return null;
	}

}
