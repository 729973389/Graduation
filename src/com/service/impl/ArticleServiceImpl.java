package com.service.impl;

import com.dao.ArticleDAO;
import com.entity.Article;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    @Resource
    private ArticleDAO articleDAO;
    @Override
    public int insertArticle(Article article) {
        return articleDAO.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDAO.updateArticle(article);
    }

    @Override
    public int deleteArticle(String articleid) {
        return articleDAO.deleteArticle(articleid);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleDAO.getAllArticle();
    }

    @Override
    public List<Article> getArticleByCond(Article article) {
        return articleDAO.getArticleByCond(article);
    }

    @Override
    public List<Article> getArticleByLike(Article article) {
        return articleDAO.getArticleByLike(article);
    }

    @Override
    public Article getArticleById(String articleid) {
        return articleDAO.getArticleById(articleid);
    }
}
