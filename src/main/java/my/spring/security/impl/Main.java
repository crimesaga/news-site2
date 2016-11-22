package my.spring.security.impl;

import java.util.List;

import my.spring.security.dto.CategoryWithNews;
import my.spring.security.entity.Article;
import my.spring.security.entity.Category;
import my.spring.security.service.ArticleService;
import my.spring.security.service.CategoryService;
import my.spring.security.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//            CategoryService categoryService = (CategoryService) context.getBean("categoryService");
//            Category category = new Category();
//            category.setId(12);
//            category.setName("Test");
//            category.setDescription("Test");
//            category.setEnabled(false);
//            category.setPosition(12);
//            category.setParent(new Category(1));
//            categoryService.saveCategory(category);
            
//            List<CategoryWithNews> result = categoryService.getCategoriesOrderByDate(3, 2);
//            for (CategoryWithNews categoryVO : result) {
//                System.out.println(categoryVO);
//            }
//            ArticleService articleService = (ArticleService) context.getBean("articleService");
//            articleService.getArticleOrderByDate(3);
      } catch (Exception e) {
          e.printStackTrace();
      }   
       
    }

}
