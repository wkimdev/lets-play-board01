package com.home.wkimdev.member.service;

import com.home.wkimdev.member.vo.MemberVO;

public interface IMemberService {
	
	// member list
	MemberVO getMemberList(MemberVO memberVO);
	
	// member join
	void memberRegister(MemberVO memberVO);
	
}
