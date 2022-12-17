package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.service.BoardService;
import org.zerock.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login/*")
@Log4j
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private final BoardService service;
	private final MemberService memberService;
	
	
	@PostMapping("/loginProcess")
	public String loginProcess(MemberVO memberVO, RedirectAttributes rttr, HttpServletRequest request) {
		MemberVO member = memberService.getMember(memberVO.getUserid(), memberVO.getPassword());
		if(null == member) {
			rttr.addFlashAttribute("failMsg", "아이디 혹은 비밀번호를 확인하세요");
			return "redirect:/login/login";
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", member);
		return "redirect:/board/list";
	}
	
	@GetMapping("/login")
	public void goLogin() {
		
	}
	
	@GetMapping("/logout")
	public String login(RedirectAttributes rttr, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		return "redirect:/login/login";
	}
	
	@PostMapping("/memberRegister")
	public String memberRegister(MemberVO member, RedirectAttributes rttr) {
		int count = memberService.registerMember(member);
		
		rttr.addFlashAttribute("result", count);
		
		return "redirect:/login/login";
	}
	
	@GetMapping("/memberRegister")
	public void memberRegisterForm() {
		
	}
	
	
	
}
