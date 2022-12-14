package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/checkId/{userid}")
	@ResponseBody
	public boolean checkId(@PathVariable("userid") String userid) {
		// id check
		if(memberService.checkId(userid)!=null) {
			//重なるidある時
			return false;
		} else {
			//重なるidなし
			return true;
		}
	}
	
	@GetMapping("/idSearch")
	public void idSearchForm() {
		
	}
	
	@PostMapping("/idSearchAction")
	public String idSearchAction(@RequestParam("password") String password, @RequestParam("name") String name,@RequestParam("email") String email, RedirectAttributes rttr) {
		MemberVO member = memberService.idSearch(password, name, email);
		
		if(member != null) {
			rttr.addFlashAttribute("idSearchMsg", member.getUserid());
			return "redirect:/login/login";
		}else {
			rttr.addFlashAttribute("failMsg", "해당정보와 일치하는 ID가 없습니다.");
			return "redirect:/login/idSearch";
		}
	}
	
	@GetMapping("/passwordSearch")
	public void passwordSearchForm() {
		
	}
	
	@PostMapping("/passwordSearchAction")
	public String passwordSearchAction(@RequestParam("userid") String userid, @RequestParam("name") String name,@RequestParam("email") String email, RedirectAttributes rttr) {
		MemberVO member = memberService.passwordSearch(userid, name, email);
		if(member != null) {
			rttr.addFlashAttribute("passwordSearchMsg", member.getPassword());
			return "redirect:/login/login";
		}else {
			rttr.addFlashAttribute("failMsg", "입력정보를 다시 확인해주세요.");
			return "redirect:/login/passwordSearch";
		}
	}
	
	
	
}
