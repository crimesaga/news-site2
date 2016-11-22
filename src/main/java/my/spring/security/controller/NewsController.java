package my.spring.security.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import my.spring.security.dto.ArticleVO;
import my.spring.security.dto.ArticleVO2;
import my.spring.security.dto.CategoryVO;
import my.spring.security.dto.CategoryWithNews;
import my.spring.security.impl.FileHandlerUtil;
import my.spring.security.service.ArticleService;
import my.spring.security.service.CategoryService;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/")
public class NewsController {
    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;

    @Autowired
    ServletContext servletContext;

    String imageFolderPath = "resources/images";

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "articlesPerCategory", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<CategoryWithNews>> getCategoryWithRecentNews(@RequestParam("numOfCategories") int numCategory,
            @RequestParam("numOfArticles") int numOfArticles) {
        List<CategoryWithNews> result = categoryService.getCategoriesOrderByDate(numCategory, numOfArticles);
        return new ResponseEntity<List<CategoryWithNews>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "getAllCategories", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<CategoryVO>> getCategories(@RequestParam("active") boolean active) {
        return new ResponseEntity<List<CategoryVO>>(categoryService.getCategoryVOs(active), HttpStatus.OK);
    }

    @RequestMapping(value = "findArticleById2", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<ArticleVO2> getArticleById(@RequestParam("articleId") int articleId) {
        return new ResponseEntity<ArticleVO2>(articleService.findArticleVOById2(articleId), HttpStatus.OK);
    }
    
    @RequestMapping(value = "findArticleByCategory", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<ArticleVO2>> getArticleByCategory(@RequestParam("categoryId") int categoryId) {
        return new ResponseEntity<List<ArticleVO2>>(articleService.findArticleVOsByCategoryId(categoryId), HttpStatus.OK);
    }

//    @RequestMapping(value = "findArticlesByUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    public ResponseEntity<List<ArticleVO>> findArticlesByUserId(@RequestParam("userId") int userId) {
//        return new ResponseEntity<List<ArticleVO>>(articleService.findArticleVOsByUserId(userId), HttpStatus.OK);
//    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

}
