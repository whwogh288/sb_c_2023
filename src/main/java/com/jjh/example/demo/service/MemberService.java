package com.jjh.example.demo.service;

import org.springframework.stereotype.Service;

import com.jjh.example.demo.repository.MemberRepository;
import com.jjh.example.demo.vo.Member;

@Service
public class MemberService {
	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public int join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		Member oldMember = getMemberByLoginId(loginId);
		
		if (oldMember != null) {
			return -1;
		}
		
		oldMember = getMemberByName(name);
		
		if (oldMember != null) {
			return -2;
		}
		
		oldMember = getMemberByNickname(nickname);
		
		if (oldMember != null) {
			return -3;
		}
		
		oldMember = getMemberByCellphoneNo(cellphoneNo);
		
		if (oldMember != null) {
			return -4;
		}
		
		oldMember = getMemberByEmail(email);
		
		if (oldMember != null) {
			return -5;
		}
		
		memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		return memberRepository.getLasteInsertId();
	
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
