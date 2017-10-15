package com.app.shopingbackend.dao;

import java.util.List;

import com.app.shopingbackend.dto.Category;

public interface CategoryDAO {
	
	public List<Category> list();
	
	public Category get(int id);
}
