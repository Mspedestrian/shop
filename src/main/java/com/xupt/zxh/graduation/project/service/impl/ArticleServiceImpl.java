package com.xupt.zxh.graduation.project.service.impl;

import com.xupt.zxh.graduation.project.bean.Article;
import com.xupt.zxh.graduation.project.dao.ArticleDao;
import com.xupt.zxh.graduation.project.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/4/3.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> listArticle() {
        List<Article> articles = articleDao.listArticle();
        return articles;
    }

    @Override
    public List<Article> listArticleByCondition(Article article) {
        List<Article> articles = articleDao.listArticleByCondition(article);
        return articles;
    }

    @Override
    public void insertArticle(Article article) {
        articleDao.insertArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleDao.deleteArticle(id);
    }
}
