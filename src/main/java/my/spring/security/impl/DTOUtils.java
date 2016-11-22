package my.spring.security.impl;

import java.util.ArrayList;
import java.util.List;

import my.spring.security.dto.ArticleVO;
import my.spring.security.dto.ArticleVO2;
import my.spring.security.dto.CategoryVO;
import my.spring.security.dto.CategoryVO2;
import my.spring.security.dto.CategoryWithNews;
import my.spring.security.entity.Article;
import my.spring.security.entity.Category;

public class DTOUtils {
    public static ArticleVO2 parseToArticleVO(Article article) {
        ArticleVO2 articleVO = new ArticleVO2();
        articleVO.setId(article.getId());
        articleVO.setTitle(article.getTitle());
        articleVO.setFeatured(article.isFeatured());
        articleVO.setImageUrl(article.getImageUrl());
        articleVO.setSummary(article.getSummary());
        articleVO.setPosted(article.getPostedDate());
        return articleVO;
    }

    public static ArticleVO parseToArticleVO2(Article article) {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setId(article.getId());
        articleVO.setTitle(article.getTitle());
        articleVO.setFeatured(article.isFeatured());
        articleVO.setImageUrl(article.getImageUrl());
        articleVO.setSummary(article.getSummary());
        articleVO.setContent(article.getContent());
        articleVO.setCategoryId(article.getCategory().getId());
        articleVO.setUserId(article.getUser().getId());
        articleVO.setPosted(article.getPostedDate());
        articleVO.setEnabled(article.isEnabled());
        return articleVO;
    }

    public static Article parseToArticle2(ArticleVO articleVO) {
        Article article = new Article();
        article.setId(articleVO.getId());
        article.setTitle(articleVO.getTitle());
        article.setFeatured(articleVO.isFeatured());
        article.setImageUrl(articleVO.getImageUrl());
        article.setSummary(articleVO.getSummary());
        article.setContent(articleVO.getContent());
        article.setPostedDate(articleVO.getPosted());
        article.setEnabled(articleVO.isEnabled());
        return article;
    }

    public static List<ArticleVO2> parseToArticleVOs(List<Article> articles) {
        List<ArticleVO2> articleVOs = new ArrayList<ArticleVO2>();
        for (Article article : articles) {
            articleVOs.add(parseToArticleVO(article));
        }
        return articleVOs;
    }

    public static CategoryVO parseToCategoryVO(Category category) {
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setId(category.getId());
        categoryVO.setName(category.getName());
        categoryVO.setEnabled(category.isEnabled());
        if (category.getParent() != null) {
            categoryVO.setParentId(category.getParent().getId());
        } else {
            categoryVO.setParentId(0);
        }

        return categoryVO;
    }

    public static List<CategoryVO> parseToCategoryVOs(List<Category> categories) {
        List<CategoryVO> categoryVOs = new ArrayList<CategoryVO>();
        for (Category category : categories) {
            categoryVOs.add(parseToCategoryVO(category));
        }
        return categoryVOs;
    }

    public static CategoryWithNews parseToCategoryWithNews(List<Category> categories) {
        CategoryWithNews result = new CategoryWithNews();
        for (Category category : categories) {
            result.setId(category.getId());
            result.setName(category.getName());
            result.setEnabled(category.isEnabled());
            result.setArticles(parseToArticleVOs(category.getArticles()));
        }
        return result;
    }

    public static List<ArticleVO> parseToArticleVOs2(List<Article> articles) {
        List<ArticleVO> articleVOs = new ArrayList<ArticleVO>(articles.size());
        for (Article article : articles) {
            articleVOs.add(DTOUtils.parseToArticleVO2(article));
        }
        return articleVOs;
    }

    // Category to CategoryVO2
    public static CategoryVO2 parseToCategoryVO2(Category category) {
        CategoryVO2 categoryVO = new CategoryVO2();
        categoryVO.setId(category.getId());
        categoryVO.setName(category.getName());
        categoryVO.setEnabled(category.isEnabled());
        categoryVO.setDescription(category.getDescription());
        categoryVO.setPosition(category.getPosition());
        if (category.getParent() != null) {
            categoryVO.setParentId(category.getParent().getId());
        } else {
            categoryVO.setParentId(0);
        }

        return categoryVO;
    }

    public static List<CategoryVO2> parseToCategoryVOs2(List<Category> categories) {
    List<CategoryVO2> result = new ArrayList<CategoryVO2>(categories.size());
    for (Category category : categories) {
        result.add(parseToCategoryVO2(category));
    }
   return result;
}

    public static Category parseToCategory2(CategoryVO2 categoryVO) {
        Category category = new Category();
        category.setId(categoryVO.getId());
        category.setName(categoryVO.getName());
        category.setEnabled(categoryVO.isEnabled());
        category.setDescription(categoryVO.getDescription());
        category.setPosition(categoryVO.getPosition());
        if (categoryVO.getParentId() == 0) {
            category.setParent(new Category());
        } else {
            category.setParent(new Category(1));
        }

        return category;
    }
}
