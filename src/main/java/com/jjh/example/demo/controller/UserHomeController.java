package com.jjh.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjh.example.demo.vo.Article;

@Controller
public class UserHomeController {
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String Main() {
		return "Hello World";			
	}
}
 

