package my.spring.security.impl;

import java.util.List;

import my.spring.security.entity.Article;

public interface ArticleDAO extends GenericDAO<Article, Integer>{
public List<Article> getArticleOrderByDate(int numOfArticles);
}
