package my.spring.security.service;

import java.util.List;

import my.spring.security.dto.CategoryVO;
import my.spring.security.dto.CategoryVO2;
import my.spring.security.dto.CategoryWithNews;
import my.spring.security.entity.Category;

public interface CategoryService {
    public List<CategoryWithNews> getCategoriesOrderByDate(Integer numOfCategories, Integer numOfArticle);
    public CategoryVO2 saveCategory(CategoryVO2 category);
    public List<CategoryVO> getCategoryVOs(boolean active);
    public List<CategoryVO2> getCategoryVOs2();
    public void deleteCategory(int categoryId);
    public void updateCategory(Category category);
}
