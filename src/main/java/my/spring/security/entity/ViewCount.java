package my.spring.security.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name = "view_count", uniqueConstraints = { @UniqueConstraint(columnNames = "articleId") })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ViewCount  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Article article;
    private int viewCount ;

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleId", nullable = false)
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
