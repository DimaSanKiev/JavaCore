package _bionic_university._4_wikipedia;

import java.util.List;

public class Article {

    private String name;
    private String url;
    private String description;
    private List<Link> innerArticles;

    public Article() {
    }

    public Article(String name, String url, String description, List<Link> innerArticles) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.innerArticles = innerArticles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Link> getInnerArticles() {
        return innerArticles;
    }

    public void setInnerArticles(List<Link> innerArticles) {
        this.innerArticles = innerArticles;
    }
}
