package com.jjh.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjh.example.demo.service.MemberService;
import com.jjh.example.demo.vo.Member;

@Controller
public class UserMemberController {
	private MemberService memberService;
	
	public UserMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		if ( loginId == null || loginId.trim().length() == 0 ) {
			return "loginId(을)를 입력해주세요";
		}
		
		if ( loginPw == null || loginPw.trim().length() == 0 ) {
			return "PassWord(을)를 입력해주세요";
		}
		
		if ( name == null || name.trim().length() == 0 ) {
			return "이름(을)를 입력해주세요";
		}
		
		if ( nickname == null || nickname.trim().length() == 0 ) {
			return "nickname(을)를 입력해주세요";
		}
		
		if ( cellphoneNo == null || cellphoneNo.trim().length() == 0 ) {
			return "휴대폰 번호(을)를 입력해주세요";
		}
		
		if ( email == null || email.trim().length() == 0 ) {
			return "e-mail(을)를 입력해주세요";
		}
		
		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		if ( id == -1 ) {
			return "해당 아이디는 이미 사용중입니다.";
		}
		
		Member member = memberService.getMemberById(id);
		
		return member;
	}
}
