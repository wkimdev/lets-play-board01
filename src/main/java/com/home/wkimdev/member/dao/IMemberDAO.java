package com.home.wkimdev.member.dao;

import java.util.List;

import com.home.wkimdev.member.vo.MemberVO;

public interface IMemberDAO {
	
	// join
	int memberInsert(MemberVO memberVO);
	
	// select
	MemberVO memberSelect(MemberVO memberVO);
	
	// select Id
	List<MemberVO> memberFindAllId();
	
	// update
	int memberUpdate(MemberVO memberVO);
	
	// delete 
	int memberDelete(MemberVO memberVO);
	
}
