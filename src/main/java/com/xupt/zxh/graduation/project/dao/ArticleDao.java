package com.xupt.zxh.graduation.project.dao;

import com.xupt.zxh.graduation.project.bean.Article;

import java.util.List;

/**
 * Created by jijie on 2017/4/9.
 */
public interface ArticleDao {
    List<Article> listArticle();

    List<Article> listArticleByCondition(Article article);

    void insertArticle(Article article);

    void updateArticle(Article article);

    void  deleteArticle(Integer id);
}
