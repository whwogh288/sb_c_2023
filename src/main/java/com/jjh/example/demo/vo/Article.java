package com.jjh.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article{
	private int id;
	private int memberId;
	private String title;
	private String body;
	private String regDate;
	private String updateDate;
	
}
