package my.spring.security.impl;

import java.util.List;

import org.hibernate.Hibernate;

import my.spring.security.entity.Article;
import my.spring.security.entity.User;
import my.spring.security.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO m_userDAO;
    private ArticleDAO m_articleDAO;

    public UserServiceImpl(UserDAO userDAO) {
        m_userDAO = userDAO;
    }

    @Override
    public User getUserByName(String name) {
        User user = m_userDAO.findByAttribute("name", name);
        Hibernate.initialize(user.getRoles());
        return user;
    }
    
    @Override
    public List<Article> getArticleByUserId(int userId) {
        User user = m_userDAO.findById(userId, false);
        List<Article> articles = user.getArticles();
        //lockArticles(articles, true);
        Hibernate.initialize(articles);
        return articles;
    }
}
