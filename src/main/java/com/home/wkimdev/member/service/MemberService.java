package com.home.wkimdev.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.wkimdev.member.dao.MemberDAO;
import com.home.wkimdev.member.vo.MemberVO;

@Service("MemberService")
public class MemberService implements IMemberService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO getMemberList(MemberVO memberVO) {
		MemberVO members = memberDAO.memberSelect(memberVO);
		
		if(members == null) {
			LOG.debug("select fail~~");
		} else {
			LOG.debug("select success~~");
		}
		return members;
	}
	
	// member join
	@Override
	public void memberRegister(MemberVO memberVO) {
		int result = memberDAO.memberInsert(memberVO);
		
		if (result == 0) {
			LOG.debug("join fail~!");
		} else {
			LOG.debug("join success~!");
		}
		
	}
	

	
}
