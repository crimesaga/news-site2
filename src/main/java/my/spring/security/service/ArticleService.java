package my.spring.security.service;

import java.util.List;

import my.spring.security.dto.ArticleVO;
import my.spring.security.dto.ArticleVO2;
import my.spring.security.entity.Article;

public interface ArticleService {
    public List<Article> getArticleOrderByDate(int numOfArticles);
    public Article saveArticle(ArticleVO articleVO);
    public void deleteArticle(int articleId);
    public List<ArticleVO2> findArticleVOsByCategoryId(int categoryId);
    public List<ArticleVO> findArticleVOsByUserId(int userId);
    public List<Article> findArticlesByUserAndCategory(int userId, int categoryId);
    public ArticleVO findArticleVOById(int articleId);
    ArticleVO2 findArticleVOById2(int articleId);
}
