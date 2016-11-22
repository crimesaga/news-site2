package my.spring.security.impl;

import java.util.List;

import my.spring.security.entity.Category;

public interface CategoryDAO  extends GenericDAO<Category, Integer> {
public List<Category> getCategoriesOrderByPosition(Integer numOfCategories);
}
