package com.home.wkimdev.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.wkimdev.member.service.MemberService;
import com.home.wkimdev.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class memberController {
	
	private static final Logger LOG = LoggerFactory.getLogger(memberController.class);
	
	@Autowired
	private MemberService memberService;
	
	
	/**
	 * memberJoin action
	 * 아.. 애를 json으로 받으면 화면 안만들어도 되는데... 이생각이 딱 드는데???
	 * 
	 */
	@RequestMapping("/memberJoin")
	//@RequestMapping(value = "/members/Join", method = RequestMethod.POST)
	public String memberJoin(MemberVO memberVO) {
		//memberService.memberRegister(memberVO);
		return "/members/Join";
	}
	
	@RequestMapping()
	public void memberSelect() {
		
	}
	
	
	
}
