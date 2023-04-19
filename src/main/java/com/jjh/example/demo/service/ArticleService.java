package com.jjh.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jjh.example.demo.repository.ArticleRepository;
import com.jjh.example.demo.utill.Ut;
import com.jjh.example.demo.vo.Article;
import com.jjh.example.demo.vo.ResultData;

@Service
public class ArticleService {
	private ArticleRepository articleRepository;
	
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	public ResultData writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		int id = articleRepository.getLastInsertId();
		
		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), id);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

}
//서비스 메서드 끝