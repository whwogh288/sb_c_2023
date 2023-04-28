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
	
	public ResultData writeArticle(int memberId, String title, String body) {
		articleRepository.writeArticle(memberId, title, body);
		int id = articleRepository.getLastInsertId();
		
		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
	}

	public List<Article> getForPrintArticles(int actorId) {
		List<Article> articles = articleRepository.getArticles();
		
		for( Article article : articles) {
			updateForPrintData(actorId, article);
		}
		
		return articles;
	}

	private void updateForPrintData(int actorId, Article article) {
		if ( article == null ) {
			return;
		}
		
		ResultData actorCanDeleteRd = actorCanDelete(actorId, article);
		
		article.setExtra_actorCanDelete(actorCanDeleteRd.isSucccess());
		
	}

	public Article getForPrintArticle(int actorId, int id) {
		Article article = articleRepository.getForPrintArticle(id);
		
		updateForPrintData(actorId, article);
		
		return article;
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public ResultData modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
		
		Article article = getForPrintArticle(0, id);
		
		return ResultData.from("S-1", Ut.f("%d번 게시물을 수정하였습니다.", id), "article", article);
	}

	public ResultData actorCanModify(int actorId, Article article) {
		if(article == null) {
			return ResultData.from("F-1", "게시물이 존재하지 않습니다.");
		}
		
		if(article.getMemberId() != actorId) {
			return ResultData.from("F-2", "권한이 없습니다.");
		}
	
		return ResultData.from("S-1", "게시물을 수정하시겠습니까?");
		
	}
	
	public ResultData actorCanDelete(int actorId, Article article) {
		if(article == null) {
			return ResultData.from("F-1", "게시물이 존재하지 않습니다.");
		}
		
		if(article.getMemberId() != actorId) {
			return ResultData.from("F-2", "권한이 없습니다.");
		}
	
		return ResultData.from("S-1", "게시물을 삭제하시겠습니까?");
		
	}

}
//서비스 메서드 끝