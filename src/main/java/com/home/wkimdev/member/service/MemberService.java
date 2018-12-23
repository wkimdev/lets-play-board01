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
	public List<MemberVO> getMemberIdList() {
		List<MemberVO> members = memberDAO.memberFindAllId();
		
		LOG.debug("MemberService start~!!!!!!!");
		
		if(members == null) {
			LOG.debug("no member id exist");
		} else {
			LOG.debug("select success~~");
		}
		return members;
	}
	
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

	@Override
	public MemberVO memberModify(MemberVO memberVO) {
		int result = memberDAO.memberUpdate(memberVO);
		
		if(result == 0) {
			LOG.debug("update fail~!!!");
			return null;
		} else {
			LOG.debug("update success~!!");
		}
		
		return memberVO;
	}

	@Override
	public int memberRemove(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO memberSearch(MemberVO memberVO) {
		
		MemberVO members = memberDAO.memberSelect(memberVO);
		
		if (members == null) {
			LOG.debug("login fail");
		} else {
			LOG.debug("login success");
		}
		
		return members;
	}

	
}
