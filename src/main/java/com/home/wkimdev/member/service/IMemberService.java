package com.home.wkimdev.member.service;

import java.util.List;

import com.home.wkimdev.member.vo.MemberVO;

public interface IMemberService {
	
	// get member Id list
	List<MemberVO> getMemberIdList();
	
	// member list
	MemberVO getMemberList(MemberVO memberVO);
	
	// member join
	void memberRegister(MemberVO memberVO);
	
	// member update
	MemberVO memberModify(MemberVO memberVO);
	
	// member delete
	int memberRemove(MemberVO memberVO);
	
	// member info
	MemberVO memberSearch(MemberVO memberVO);
	
}
