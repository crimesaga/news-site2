package my.spring.security.dto;

import java.util.List;

import my.spring.security.entity.Article;

public class CategoryWithNews {

    private int id;
    private String name;
    private boolean enabled;
    private List<ArticleVO2> articles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<ArticleVO2> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleVO2> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Category: " + name + ": ";
        str += "[";
        for (ArticleVO2 article : articles) {
            str += "  Article: " + article.getTitle();
        }
        str += "]";
        return str;
    }
}
