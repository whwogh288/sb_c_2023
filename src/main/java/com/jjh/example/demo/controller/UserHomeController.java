package com.jjh.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UserHomeController {
	@RequestMapping("/usr/home/getString")
	@ResponseBody
	public String getString() {
		return "HI";			
	}
	@RequestMapping("/usr/home/getInt")
	@ResponseBody
	public int getInt() {
		return 5;			
	}
	@RequestMapping("/usr/home/getFloat")
	@ResponseBody
	public float getFloat() {
		return 5.5f;			
	}
	@RequestMapping("/usr/home/getDouble")
	@ResponseBody
	public double getDouble() {
		return 5.5;			
	}
	@RequestMapping("/usr/home/getBoolean")
	@ResponseBody
	public boolean getBoolean() {
		return true;			
	}
	@RequestMapping("/usr/home/getCharacter")
	@ResponseBody
	public char getCharacter() {
		return 'a';			
	}
	@RequestMapping("/usr/home/getMap")
	@ResponseBody
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("철수나이", 22);
		map.put("영희나이", 21);
		
		return map;			
	}
	@RequestMapping("/usr/home/getList")
	@ResponseBody
	public List<String> getList() {
		List<String> list = new ArrayList<>();
		list.add("철수");
		list.add("영희");
		
		return list;			
	}
	@RequestMapping("/usr/home/getArticle")
	@ResponseBody
	public Article getArticle() {
		Article article = new Article(1, "제목1");
		
		return article;			
	}
	@RequestMapping("/usr/home/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		Article article1 = new Article(1, "제목1");
		Article article2 = new Article(2, "제목2");
		
		List<Article> list = new ArrayList<>();
		list.add(article1);
		list.add(article2);
		
		return list;			
	}
}
 
 @Data
 @NoArgsConstructor
 @AllArgsConstructor
class Article{
	public int id;
	public String title;
	
	
}
