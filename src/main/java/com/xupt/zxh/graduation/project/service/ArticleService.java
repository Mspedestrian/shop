package com.xupt.zxh.graduation.project.service;

import com.xupt.zxh.graduation.project.bean.Article;

import java.util.List;

/**
 * Created by admin on 2017/4/3.
 */
public interface ArticleService {

    List<Article> listArticle();

    List<Article> listArticleByCondition(Article article);

    void insertArticle(Article article);

    void updateArticle(Article article);

    void  deleteArticle(Integer id);
}
