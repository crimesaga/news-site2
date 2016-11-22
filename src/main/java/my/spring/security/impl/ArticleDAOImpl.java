package my.spring.security.impl;

import java.util.List;

import my.spring.security.entity.Article;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class ArticleDAOImpl extends GenericHibernateDAO<Article, Integer> implements ArticleDAO{

    public ArticleDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Article> getArticleOrderByDate(int numOfArticles) {
        String sqlStr = "from Article order by article.category";
        Query query = getSession().createQuery(sqlStr);
        query.setCacheable(true);
        return query.list();
    }

}
