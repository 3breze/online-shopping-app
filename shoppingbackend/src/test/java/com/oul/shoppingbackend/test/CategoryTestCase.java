package com.oul.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oul.shoppingbackend.dao.CategoryDao;
import com.oul.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.oul.shoppingbackend");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}

	/*
	 * Provera da li add radi kako treba
	 */
	// @Test
	// public void testAddCategory(){
	// category = new Category();
	// category.setName("NovoGovno");
	// category.setDescription("Some random desc");
	// category.setImageURL("CAT_5.png");
	//
	// assertEquals("Successfully added a category inside the
	// table",true,categoryDao.add(category));
	//
	// }

	/*
	 * Ovo sluzi samo za proveru da li get() iz categoryDao radi kako treba
	 * ocekujemo da nam za id 2 da 'laptop' sto JUNIT i potvrdi
	 */

	// @Test
	// public void testGetCategory(){
	// category = categoryDao.get(2);
	// drugi argument ('Laptop') je ono sto method u trecem argumentu treba da
	// nam vrati
	// assertEquals("Successfully fetched a single category from the
	// table","Laptop",category.getName());
	// }

	// @Test
	// public void testUpdateCategory(){
	// category = categoryDao.get(2);
	// category.setName("TV");
	// assertEquals("Successfully updated a single category in the
	// table",true,categoryDao.update(category));
	//
	// }
	// @Test
	// public void testDeleteCategory() {
	// category = categoryDao.get(1);
	// assertEquals("Successfully deleted a single category in the table", true,
	// categoryDao.delete(category));
	//
	// }

	// @Test
	// public void testListCategory(){
	//
	// assertEquals("Successfully fetched the list of categories from the
	// table", 3, categoryDao.list().size());
	// }

	@Test
	public void testCRUDCategory() {
		// ADD
		category = new Category();
		category.setName("Teli");
		category.setDescription("Some random desc");
		category.setImageURL("CAT_1.png");
		assertEquals("Something went wrong while adding a category inside the table", true, categoryDao.add(category));

		category = new Category();
		category.setName("Laptop");
		category.setDescription("Some random desc");
		category.setImageURL("CAT_2.png");
		assertEquals("Something went wrong while adding a category inside the table", true, categoryDao.add(category));

		// fetching and updating/renaming
		category = categoryDao.get(1);
		category.setName("TV");
		assertEquals("Something went wrong while updating a single category in the table", true, categoryDao.update(category));

		// DELETE
		assertEquals("Something went wrong while deleting a single category in the table", true, categoryDao.delete(category));

		// LISTING
		assertEquals("Something went wrong while fetching the list of categories from the table", 1, categoryDao.list().size());
	}

}
