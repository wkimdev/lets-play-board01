package com.home.wkimdev.member.controller;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.home.wkimdev.member.service.MemberService;
import com.home.wkimdev.member.vo.MemberVO;

@Controller
@RequestMapping("/members")
public class memberController {
	
	private static final Logger LOG = LoggerFactory.getLogger(memberController.class);
	
	@Autowired
	private MemberService memberService;
	
	// ? 이게 왜 필요한지 모르겠다.
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		return dateFormat.format(date);
	}
	
	@RequestMapping("/memberId")
	public ModelAndView memberFindAllId(){
//		List<MemberVO> member = memberService.getMemberIdList(); 	
		LOG.debug("call this url");
		
		//list
		//List<MemberVO> member = memberService.getMemberIdList();
//		List<MemberVO> member = new ArrayList<MemberVO>();
		
		//return back to index.jsp
//		ModelAndView model = new ModelAndView("member/memberList");
//		model.addObject("lists", list);
//		return model;
		
		List<MemberVO> member = memberService.getMemberIdList();
		LOG.debug("member list : "+member);
		
        ModelAndView mv=new ModelAndView();
        LOG.debug("call uri 11111111111111");
        mv.setViewName("member/memberList");
        mv.addObject("mem", member);
        
        LOG.debug("call uri 2222222222222");
        return mv;
	}
	
	/**
	 * memberJoin page call
	 * 단순한 화면 호출 GET
	 * 아.. 애를 json으로 받으면 화면 안만들어도 되는데... 이생각이 딱 드는데???
	 * 
	 */
	@RequestMapping("/memberJoin")
	public String memberJoin(MemberVO memberVO) {
		return "member/memberJoin";
	}
	
	/* 
	 * member join post action (submit button 을 클릭하면 /members/join)
	 */
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinReg(MemberVO memberVO) {
		// insert button
		memberService.memberRegister(memberVO);
		
		// memberDAO.memberInsert 에 추가하는 argument 형태로 return 을 받는다???
		return "member/joinOk";
	}
	
/*	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinReg(Member member) {
		service.memberRegister(member);
		return "/member/joinOk";
	}*/
	
	
	// jsp 화면 호출
	@RequestMapping(value = "/modifyForm")
	public ModelAndView modifyForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		
		ModelAndView mav = new ModelAndView();
		// session이 물고온 user정보를 가져와야 함.
		mav.addObject("memberVO", memberService.memberSearch(memberVO));
		mav.setViewName("member/modifyForm");
		
		return null;
	}
	
	// jsp 화면에서 post요청할때 아래 실행
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView memberModify(MemberVO memberVO, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject(attributeValue)
		
		MemberVO members = memberService.memberModify(memberVO);
		if(members == null) {
			mav.setViewName("/member/modifyForm");
		} else {
			LOG.debug("don't know...");
//			session.setAttribute("member", members);
//			
//			mav.addObject("memAft", members);
//			mav.setViewName("/member/modifyOk");
		}
		
		return mav;
	}
	
	
	
}
