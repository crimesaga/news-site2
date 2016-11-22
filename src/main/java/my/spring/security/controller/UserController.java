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
import my.spring.security.dto.CategoryVO2;
import my.spring.security.entity.Article;
import my.spring.security.impl.DTOUtils;
import my.spring.security.impl.FileHandlerUtil;
import my.spring.security.impl.UserAdapter;
import my.spring.security.service.ArticleService;
import my.spring.security.service.CategoryService;
import my.spring.security.service.UserService;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired@Qualifier("userService")
    private UserService m_userService;
    
    @Autowired@Qualifier("categoryService")
    private CategoryService m_categoryService;
    
    @Autowired
    @Qualifier("articleService")
    private ArticleService articleService;
    
    @Autowired
    ServletContext servletContext;

    String imageFolderPath = "resources/images";

    public UserService getUserService() {
        return m_userService;
    }

    public void setUserTypeService(UserService userService) {
        m_userService = userService;
    }

    // @RequestMapping(value = "login")
    // public String login() {
    // return "login";
    // }

//    @RequestMapping(value = "admin", method = RequestMethod.GET)
//    public ModelAndView adminPage() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security Custom Login Form");
//        model.addObject("message", "This is protected page!");
//        model.setViewName("admin");
//
//        return model;
//    }
    
    @RequestMapping(value = "user-page", method = RequestMethod.GET)
    public ModelAndView userPage() {

        ModelAndView model = new ModelAndView();
        //model.addObject("title", "Spring Security Custom Login Form");
        //model.addObject("message", "This is protected page!");
        model.setViewName("user-page");

        return model;
    }
    
    @RequestMapping(value = { "/", "welcome" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security Custom Login Form");
//        model.addObject("message", "This is welcome page!");
        model.setViewName("admin_page");
        return model;
    }
    
    @RequestMapping(value = { "admin"}, method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("admin_page");
        return model;
    }

    @RequestMapping(value = "articlesByUser", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ArticleVO2>> saveJsonData(@RequestParam("userId") int userId) {
        List<Article> articles = m_userService.getArticleByUserId(userId);
        return new ResponseEntity<List<ArticleVO2>>(DTOUtils.parseToArticleVOs(articles), HttpStatus.OK);
    }
    
    @RequestMapping(value = "findAllCategoriesWithPermission", method = RequestMethod.GET, produces = "application/json") 
    public ResponseEntity<List<CategoryVO2>> findAllCategory() {
        List<CategoryVO2> result = m_categoryService.getCategoryVOs2();
        return new ResponseEntity<List<CategoryVO2>>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value = "saveCategory", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<CategoryVO2> saveCategory(@RequestBody CategoryVO2 categoryVO) {
       // m_categoryService.saveCategory(categoryVO);
        return new ResponseEntity<CategoryVO2>(m_categoryService.saveCategory(categoryVO), HttpStatus.OK);
    }
    
    @RequestMapping(value = "deleteCategory", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteCategory(@RequestParam int categoryId) {
        m_categoryService.deleteCategory(categoryId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "saveArticle", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public ResponseEntity<Void> saveArticle(@RequestBody ArticleVO articleVO) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserAdapter) {
                articleVO.setUserId(((UserAdapter) principal).getUserId());
            }
        }
        articleService.saveArticle(articleVO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "findArticlesByUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<ArticleVO>> findArticlesByUserId(@RequestParam("userId") int userId) {
        return new ResponseEntity<List<ArticleVO>>(articleService.findArticleVOsByUserId(userId), HttpStatus.OK);
    }
    
    @RequestMapping(value = "findArticleById", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<ArticleVO> getArticleById(@RequestParam("articleId") int articleId) {
        return new ResponseEntity<ArticleVO>(articleService.findArticleVOById(articleId), HttpStatus.OK);
    }
    
    @RequestMapping(value = "upload_image", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> addPersonFromForm(@RequestParam(value = "folderId") int folderId,
            @RequestParam(value = "image", required = false) MultipartFile image, HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        System.out.println("+++++++++++++++++++++++++++" + folderId);
        if (!image.isEmpty()) {
            String imageName = FileHandlerUtil.randInt(1, Integer.MAX_VALUE) + ".jpg";
            String folderName = null;
            if (folderId == 0) {
                folderName = String.valueOf(FileHandlerUtil.randInt(1, Integer.MAX_VALUE));
            } else {
                folderName = String.valueOf(folderId);
            }

            try {
                String servletAbsPath = servletContext.getRealPath("/");
                FileHandlerUtil.validateImage(image);
                FileHandlerUtil.saveImage(servletAbsPath + imageFolderPath + "/" + folderName + "/", imageName, image);

            } catch (RuntimeException re) {

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String uploadPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"
                    + imageFolderPath + "/" + folderName + '/' + imageName;
            result.put("link", uploadPath);
        }

        return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "delete_image", method = RequestMethod.GET)
    public ResponseEntity<Void> deleteImage(@RequestParam(value = "imageUrl") String imageUrl) throws IOException {
        String servletAbsPath = servletContext.getRealPath("/");
        String imageName = imageUrl.substring(imageUrl.indexOf(imageFolderPath));
        String imagePath = servletAbsPath + imageName;
        FileUtils.forceDelete(new File(imagePath));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "replace_image")
    public ResponseEntity<Map<String, String>> replaceImage(@RequestParam("replacedImage") String imageUrl,
            @RequestParam(value = "image", required = false) MultipartFile image) {
        Map<String, String> result = new HashMap<String, String>();
        return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
    }

    // @RequestMapping()
    // public String getAll(ModelMap modelMap) {
    // modelMap.put("usertypes", m_userTypeService.getAllUserTypes());
    // return "all";
    // }

    // @RequestMapping(value = "onewithjson/{id}", method = RequestMethod.GET, produces = "application/json")
    // public @ResponseBody ResponseEntity<UserType> getOneWithJson(@PathVariable int id) {
    // UserType userType = m_userTypeService.findByAttribute("id", id);
    // return new ResponseEntity<UserType>(userType, HttpStatus.OK);
    // }
}
