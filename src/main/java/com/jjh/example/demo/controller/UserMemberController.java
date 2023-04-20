package com.jjh.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjh.example.demo.service.MemberService;
import com.jjh.example.demo.utill.Ut;
import com.jjh.example.demo.vo.Member;
import com.jjh.example.demo.vo.ResultData;

@Controller
public class UserMemberController {
	private MemberService memberService;
	
	public UserMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		if (Ut.empty(loginId)) {
			return ResultData.from("F-1", "loginId(을)를 입력해주세요");
		}
		
		if (Ut.empty(loginPw)) {
			return ResultData.from("F-2", "loginPw(을)를 입력해주세요");
		}
		
		if (Ut.empty(name)) {
			return ResultData.from("F-3", "name(을)를 입력해주세요");
		}
		
		if (Ut.empty(nickname)) {
			return ResultData.from("F-4", "nickname(을)를 입력해주세요");
		}
		
		if (Ut.empty(cellphoneNo)) {
			return ResultData.from("F-5", "cellphoneNo(을)를 입력해주세요");
		}
		
		if (Ut.empty(email)) {
			return ResultData.from("F-6", "email(을)를 입력해주세요");
		}
		
		ResultData joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		if ( joinRd.isFail() ) {
			return joinRd;
		}
		
		Member member = memberService.getMemberById((int)joinRd.getData1());
		
		return ResultData.newData(joinRd, member);
	}
}
