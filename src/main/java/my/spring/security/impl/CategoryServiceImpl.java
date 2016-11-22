package my.spring.security.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import my.spring.security.dto.ArticleVO2;
import my.spring.security.dto.CategoryVO;
import my.spring.security.dto.CategoryVO2;
import my.spring.security.dto.CategoryWithNews;
import my.spring.security.entity.Article;
import my.spring.security.entity.Category;
import my.spring.security.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);
    private CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<CategoryWithNews> getCategoriesOrderByDate(Integer numOfCategories, Integer numOfArticle) {
        long startingTime = System.currentTimeMillis();
        List<CategoryWithNews> categoryWithNewsList = new ArrayList<CategoryWithNews>(numOfCategories);
        List<Category> results = categoryDAO.getCategoriesOrderByPosition(numOfCategories);
        int articleCount = 0;
        for (Category category : results) {
            CategoryWithNews categoryWithNews = new CategoryWithNews();
            categoryWithNews.setId(category.getId());
            categoryWithNews.setName(category.getName());
            categoryWithNews.setEnabled(category.isEnabled());
            List<Article> articles = category.getArticles();
            int size = articles.size();
            List<ArticleVO2> articleVOs;
            if (size >= numOfArticle) {
                articleVOs = new ArrayList<ArticleVO2>(DTOUtils.parseToArticleVOs(articles.subList(0, numOfArticle)));
            } else {
                articleVOs = new ArrayList<ArticleVO2>(DTOUtils.parseToArticleVOs(articles.subList(0, size)));
            }
            articleCount += size;
            categoryWithNews.setArticles(articleVOs);
            categoryWithNewsList.add(categoryWithNews);
        }
        logger.debug("Fetching " + categoryWithNewsList.size() + " categories with " + articleCount + " articles taking:"
                + (System.currentTimeMillis() - startingTime));
        return categoryWithNewsList;
    }

    @Override
    public CategoryVO2 saveCategory(CategoryVO2 categoryVO) {
        Category category = DTOUtils.parseToCategory2(categoryVO);
        // Category parent = categoryDAO.getById(categoryVO.getParentId(), false);
        // category.setParent(parent);
        categoryDAO.makePersistentBySave(category);
        categoryVO.setId(category.getId());
        return categoryVO;
    }

    @Override
    public List<CategoryVO> getCategoryVOs(boolean active) {
        List<Category> categories = null;
        List<CategoryVO> categoryVOs = new ArrayList<CategoryVO>();
        if (active) {
            categories = categoryDAO.findAllByAttribute("enabled", active);
        } else {
            categories = categoryDAO.findAll();
        }
        for (Category category : categories) {
            categoryVOs.add(DTOUtils.parseToCategoryVO(category));
        }
        return (List<CategoryVO>) categoryVOs;
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryDAO.delete(categoryId);

    }

    @Override
    public void updateCategory(Category category) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<CategoryVO2> getCategoryVOs2() {
        return DTOUtils.parseToCategoryVOs2(categoryDAO.findAll());
    }
}
