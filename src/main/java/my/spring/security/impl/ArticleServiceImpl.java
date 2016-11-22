package my.spring.security.impl;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import my.spring.security.dto.ArticleVO;
import my.spring.security.dto.ArticleVO2;
import my.spring.security.entity.Article;
import my.spring.security.entity.Category;
import my.spring.security.entity.User;
import my.spring.security.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
    private static final Logger logger = Logger.getLogger(ArticleServiceImpl.class);
    private ArticleDAO articleDAO;
    private CategoryDAO categoryDAO;
    private UserDAO userDAO;
    public ArticleServiceImpl(ArticleDAO articleDAO, CategoryDAO categoryDAO, UserDAO userDAO) {
        this.articleDAO = articleDAO;
        this.categoryDAO = categoryDAO;
        this.userDAO = userDAO;
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
    }
    @Override
    public List<Article> getArticleOrderByDate(int numOfArticles) {
        for (Article article : articleDAO.getArticleOrderByDate(numOfArticles)) {
            System.out.println("  Article: " + article.getTitle());
        }
        return null;
    }
    @Override
    public Article saveArticle(ArticleVO articleVO) {
        Article article = DTOUtils.parseToArticle2(articleVO);
        Category category = categoryDAO.findById(articleVO.getCategoryId(), false);
        User user = userDAO.findById(articleVO.getUserId(), false);
        article.setCategory(category);
        article.setUser(user);
        article.setPostedDate(new Date());
        return articleDAO.makePersistent(article);
    }
    @Override
    public void deleteArticle(int articleId) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public List<ArticleVO2> findArticleVOsByCategoryId(int categoryId) {
        return DTOUtils.parseToArticleVOs(articleDAO.findAllByAttribute("category.id", categoryId));
    }
    @Override
    public List<ArticleVO> findArticleVOsByUserId(int userId) {
        return DTOUtils.parseToArticleVOs2(articleDAO.findAllByAttribute("user.id", userId));
    }
    @Override
    public List<Article> findArticlesByUserAndCategory(int userId, int categoryId) {
        // TODO Auto-generated method stub
        return null;
    }
    
    //For altering articles
    @Override
    public ArticleVO findArticleVOById(int articleId) {
        long startingTime = System.currentTimeMillis();
        ArticleVO articleVO = null;
        Article article = null;
        try {
            article = articleDAO.findById(articleId, false);
            articleVO = DTOUtils.parseToArticleVO2(article);
        } finally {
            //Update view count
            if (article != null) {
//                int oldValue = article.getViewCount().getViewCount();
//                article.getViewCount().setViewCount(oldValue + 1);
            }
           
        }
        logger.debug("Finding Article id:" + articleId + " took:" + (System.currentTimeMillis() - startingTime));
        return articleVO;
        
    }
    
    //For showing articles
    @Override
    public ArticleVO2 findArticleVOById2(int articleId) {
        return DTOUtils.parseToArticleVO(articleDAO.findById(articleId, false));
    }
}
