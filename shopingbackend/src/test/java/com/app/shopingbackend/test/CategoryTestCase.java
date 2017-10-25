package com.app.shopingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.shopingbackend.dao.CategoryDAO;
import com.app.shopingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.app.shopingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	
	/*@Test 
	public void testAddCategory(){ 
	  	category = new Category();
	  	category.setName("Laptop");
	  	category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
	  	assertEquals("Successfully added a category inside a table!",true,categoryDAO.add(category)); 
	 }*/
	 

	
	/* @Test 
	public void testGetCategory(){ 
	 	category = categoryDAO.get(8);
	 	assertEquals("Successfully fatched a single category from the table!","Mobile",category.getName());
	}*/
	 

	
	/*@Test 
	public void testUpdateCategory(){ 
	  	category = categoryDAO.get(18);
	  	category.setName("TV");
	  	assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category)); 
	}*/
	
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(13);
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));
	}*/
	 
	 

	
	 	/*@Test public void testListCategory(){
	 	assertEquals("Successfully fetched the list of category from the table!",2,categoryDAO.list().size()); 
	 	}*/
	 
	@Test
	public void testCRUDCategory() {

		//add operation
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added a category inside a table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added a category inside a table!", true, categoryDAO.add(category));
		
		//fetching and updating the category
		category = categoryDAO.get(2);
	  	category.setName("TV");
	  	assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category)); 
	  	
	  	//delete the category
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));
		
		//fetching the listCategory
		assertEquals("Successfully fetched the list of category from the table!",1,categoryDAO.list().size()); 

	}
}
