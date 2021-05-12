package com.dao;

import com.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("articleDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ArticleDAO {
    // 插入数据 调用articleDAO里的insertArticle配置
    public int insertArticle(Article article);

    // 更新数据 调用articleDAO里的updateArticle配置
    public int updateArticle(Article article);

    // 删除数据 调用articleDAO里的deleteArticle配置
    public int deleteArticle(String articleid);

    // 查询全部数据 调用articleDAO里的getAllArticle配置
    public List<Article> getAllArticle();

    // 按照Article类里面的字段名称精确查询 调用articleDAO里的getArticleByCond配置
    public List<Article> getArticleByCond(Article article);

    // 按照Article类里面的字段名称模糊查询 调用articleDAO里的getArticleByLike配置
    public List<Article> getArticleByLike(Article article);

    // 按主键查询表返回单一的Article实例 调用articleDAO里的getArticleById配置
    public Article getArticleById(String articleid);
}
