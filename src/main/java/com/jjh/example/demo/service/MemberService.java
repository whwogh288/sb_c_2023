package com.jjh.example.demo.service;

import org.springframework.stereotype.Service;

import com.jjh.example.demo.repository.MemberRepository;
import com.jjh.example.demo.utill.Ut;
import com.jjh.example.demo.vo.Member;
import com.jjh.example.demo.vo.ResultData;

@Service
public class MemberService {
	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public ResultData join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		Member oldMember = getMemberByLoginId(loginId);
		
		if (oldMember != null) {
			return ResultData.from("F-7", Ut.f("해당 아이디(%s)는 이미 사용중입니다.", loginId));
		}
		
		oldMember = getMemberByName(name);
		
		if (oldMember != null) {
			return ResultData.from("F-8", Ut.f("해당 이름(%s)(은)는 이미 사용중입니다.", name));
		}
		
		oldMember = getMemberByNickname(nickname);
		
		if (oldMember != null) {
			return ResultData.from("F-9", Ut.f("해당 닉네임(%s)(은)는 이미 사용중입니다.", nickname));
		}
		
		oldMember = getMemberByCellphoneNo(cellphoneNo);
		
		if (oldMember != null) {
			return ResultData.from("F-10", Ut.f("해당 휴대전화번호(%s)는 이미 사용중입니다.", cellphoneNo));
		}
		
		oldMember = getMemberByEmail(email);
		
		if (oldMember != null) {
			return ResultData.from("F-11", Ut.f("해당 email(%s)는 이미 사용중입니다.", email));
		}
		
		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		int id = memberRepository.getLasteInsertId();
		
		return ResultData.from("S-1", "회원가입이 완료되었습니다.", id);
	
	}

	private Member getMemberByEmail(String email) {
		return memberRepository.getMemberByEmail(email);
	}

	private Member getMemberByCellphoneNo(String cellphoneNo) {
		return memberRepository.getMemberByCellphoneNo(cellphoneNo);
	}

	private Member getMemberByNickname(String nickname) {
		return memberRepository.getMemberByNickname(nickname);
	}

	private Member getMemberByName(String name) {
		return memberRepository.getMemberByName(name);
	}

	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
}
