package com.example.deepjyoti.sayitoutv1;

public class Article {
    private String article_title;
    private String article_content;

    public Article(String article_name, String article_content) {
        this.article_title = article_name;
        this.article_content = article_content;
    }

    public String getArticle_title() {

        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }
    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    /*public int getArticle_timestamp() {
        return article_timestamp;
    }

    public void setArticle_timestamp(int article_timestamp) {
        this.article_timestamp = article_timestamp;
    } */
}
