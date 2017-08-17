package com.oul.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oul.shoppingbackend.dao.CategoryDao;
import com.oul.shoppingbackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();

	// static {
	// Category category = new Category();
	// // adding first category
	// category.setId(1);
	// category.setName("Television");
	// category.setDescription("Some random ass description ");
	// category.setImageURL("CAT_1.png");
	// categories.add(category);
	//
	// category = new Category();
	// category.setId(2);
	// category.setName("Mobile");
	// category.setDescription("Some new random ass description ");
	// category.setImageURL("CAT_2.png");
	// categories.add(category);
	//
	// category = new Category();
	// category.setId(3);
	// category.setName("Laptop");
	// category.setDescription("Some new new random ass description ");
	// category.setImageURL("CAT_3.png");
	// categories.add(category);
	// }

	@Override
	public List<Category> list() {
		// return categories; // back when static list still existed
		// HQL (hibernate query language) its not SQL
		// entity name not table name -thus 'Category'
		String selectActiveCategory = "FROM Category WHERE active =:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		// for(Category c:categories){
		// if(c.getId() == id) return c;
		// }
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		category.setActive(true);
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
