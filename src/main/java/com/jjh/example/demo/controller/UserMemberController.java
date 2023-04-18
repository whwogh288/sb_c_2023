package com.jjh.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjh.example.demo.service.MemberService;
import com.jjh.example.demo.utill.Ut;
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
		if (Ut.empty(loginId)) {
			return "loginId(을)를 입력해주세요";
		}
		
		if (Ut.empty(loginPw)) {
			return "PassWord(을)를 입력해주세요";
		}
		
		if (Ut.empty(name)) {
			return "이름(을)를 입력해주세요";
		}
		
		if (Ut.empty(nickname)) {
			return "nickname(을)를 입력해주세요";
		}
		
		if (Ut.empty(cellphoneNo)) {
			return "휴대폰 번호(을)를 입력해주세요";
		}
		
		if (Ut.empty(email)) {
			return "e-mail(을)를 입력해주세요";
		}
		
		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		if ( id == -1 ) {
			return Ut.f("해당 아이디(%s)는 이미 사용중입니다.", loginId);
		}
		
		if ( id == -2 ) {
			return Ut.f("해당 이름(%s)은 이미 사용중입니다.", name);
		}
		
		if ( id == -3 ) {
			return Ut.f("해당 닉네임(%s)은 이미 사용중입니다.", nickname);
		}
		
		if ( id == -4 ) {
			return Ut.f("해당 휴대폰번호(%s)는 이미 등록되어 있습니다.", cellphoneNo);
		}
		
		if ( id == -5 ) {
			return Ut.f("해당 email(%s)은 이미 사용중입니다.", email);
		}
		
		Member member = memberService.getMemberById(id);
		
		return member;
	}
}
