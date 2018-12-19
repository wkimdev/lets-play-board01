package com.home.wkimdev.member.dao;

import com.home.wkimdev.member.vo.MemberVO;

public interface IMemberDAO {
	
	// join
	int memberInsert(MemberVO memberVO);
	
	// select
	MemberVO memberSelect(MemberVO memberVO);
	
}
