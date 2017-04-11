package com.xupt.zxh.graduation.project.controller;


import com.xupt.zxh.graduation.project.bean.Article;
import com.xupt.zxh.graduation.project.bean.ResponseInfo;
import com.xupt.zxh.graduation.project.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by jijie on 2017/4/9.
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取所有的
     * @return
     */
    @RequestMapping(value = "/getAllArticle")
    public @ResponseBody
    ResponseInfo getAllArticle(){
        ResponseInfo responseInfo = new ResponseInfo();
        List<Article> articles = articleService.listArticle();
        responseInfo.setData(articles);
        return responseInfo;
    }

    /**
     * 按条件查找，名称模糊查询，类别
     * @param article
     * @return
     */
    @RequestMapping(value = "/getArticleByCondition",method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo getArticleByCondition(@RequestBody Article article){
        ResponseInfo responseInfo = new ResponseInfo();
        List<Article> articles = articleService.listArticleByCondition(article);
        responseInfo.setData(articles);
        return responseInfo;
    }

    /**
     * 插入商品
     * @param article
     * @return
     */
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo addArticle(@RequestBody Article article){
        ResponseInfo responseInfo = new ResponseInfo();
        articleService.insertArticle(article);
        return responseInfo;
    }

    /**
     * 更新商品
     * @param article
     * @return
     */
    @RequestMapping(value = "/updateArticle",method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo updateArticle(@RequestBody Article article){
        ResponseInfo responseInfo = new ResponseInfo();
        articleService.updateArticle(article);
        return responseInfo;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteArticle/{id}",method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public @ResponseBody ResponseInfo deleteArticle(@PathVariable Integer id){
        ResponseInfo responseInfo = new ResponseInfo();
        articleService.deleteArticle(id);
        return responseInfo;
    }

}
