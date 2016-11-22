package my.spring.security.impl;

import java.util.List;

import my.spring.security.entity.Category;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class CategoryDAOImpl extends GenericHibernateDAO<Category, Integer> implements CategoryDAO {
    public CategoryDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Category> getCategoriesOrderByPosition(Integer numOfCategories) {
        String sqlStr = "from Category order by position";
        Query query = getSession().createQuery(sqlStr).setMaxResults(numOfCategories);
        query.setCacheable(true);
        query.setCacheRegion("query.category.getCategoriesOrderByPosition");
        return query.list();
    }

    public List<Category> getSortedCategories(int numOfCategories, int numOfArticle, String columnName) {
        return null;
    }
}
