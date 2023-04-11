package com.jjh.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jjh.example.demo.vo.Article;

@Mapper
public interface ArticleRepository {
	// 서비스 메서드 시작
	public Article writeArticle(String title, String body);

	public Article getArticle(int id);
	
	public void deleteArticle(int id);
	
	public void modifyArticle(int id, String title, String body);
	
	public List<Article> getArticles();
}
