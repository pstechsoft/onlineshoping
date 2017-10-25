package com.app.shopingbackend.dao;

import java.util.List;

import com.app.shopingbackend.dto.Category;

public interface CategoryDAO {

	public Category get(int id);

	public List<Category> list();

	public boolean add(Category category);

	public boolean update(Category category);

	public boolean delete(Category category);
}
