package com.oul.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oul.shoppingbackend.dao.ProductDao;
import com.oul.shoppingbackend.dto.Category;
import com.oul.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDao productDao;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.oul.shoppingbackend");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
	}

	// @Test
	// public void testCRUDCategory() {
	// // ADD
	// product = new Product();
	// product.setName("ime1");
	// product.setBrand("Marka1");
	// product.setDescription("Random ass desd");
	// product.setUnitPrice(25000);
	// product.setActive(true);
	// product.setCategoryId(2);
	// product.setSupplierId(2);
	//
	// assertEquals("Something went wrong while adding a category inside the
	// table", true, productDao.add(product));
	//
	// // fetching and updating/renaming
	// product = productDao.get(1);
	// product.setName("ajfona bajo");
	// assertEquals("Something went wrong while updating a single category in
	// the table", true, productDao.update(product));
	//
	// // DELETE
	// assertEquals("Something went wrong while deleting a single category in
	// the table", true, productDao.delete(product));
	//
	// // LISTING
	// assertEquals("Something went wrong while fetching the list of categories
	// from the table", 6, productDao.list().size());
	// }

	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of categories from the table", 5,
				productDao.listActiveProducts().size());
	}

	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of categories from the table", 2,
				productDao.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of categories from the table", 2,
				productDao.listActiveProductsByCategory(1).size());
	}

	@Test
	public void testListLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of categories from the table", 3,
				productDao.listLatestActiveProducts(3).size());
	}
}
