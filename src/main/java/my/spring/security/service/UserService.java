package my.spring.security.service;

import java.util.List;

import my.spring.security.entity.Article;
import my.spring.security.entity.User;

public interface UserService {
    public User getUserByName(String name);

    List<Article> getArticleByUserId(int userId);
}
