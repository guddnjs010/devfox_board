package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO memberVO, RedirectAttributes rttr, HttpServletRequest request) {
		MemberVO memberVO2 = new MemberVO();
		HttpSession session = request.getSession();
		if(null == memberVO2) {
			return "redirect:/login";
		}
		session.setAttribute("user", memberVO2);
		MemberVO memberVO3 = (MemberVO)session.getAttribute("user");
		memberVO3.getUserid();
		return "/home";
	}
	
	@GetMapping("/login")
	public void goLogin() {
		
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
