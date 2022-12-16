package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	private final BoardService service;
	private final ReplyService replyService;

	//paging処理の前
	
	//@GetMapping("/list")
	//public void list(Model model) {
	//	log.info("list.............");
	//	
	//	model.addAttribute("list", service.getList());
	//	
	//}
	
	//paging処理したリスト
	@GetMapping("/list")
	public void list(Criteria cri, Model model, HttpServletRequest request) {
		
		log.info(cri);
		log.info("list.............");
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri) ));
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO memberVo = (MemberVO)session.getAttribute("user"); 
		log.info("board : " + board);
		board.setWriter(memberVo.getUserid());
		 Long bno = service.register(board);
		 
		 //一回だけ"result"にbnoを込めてboard/listに届けるメソッド
		 rttr.addFlashAttribute("result", bno);
		 
		 return "redirect:/board/list";
		
	}
	
	//bnoをパラメータに受けてmodelに込める
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO memberVo = (MemberVO)session.getAttribute("user"); 
		log.info("getUserid : " + memberVo.getUserid());
		
		model.addAttribute("board", service.get(bno));
		model.addAttribute("replyList", replyService.getList(cri, bno));
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.get(bno));
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		int count = service.modify(board);
		
		if(count ==1) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {
		int count = service.remove(bno);
		
		if(count ==1) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/register")
	public void registerGET() {
		//登録画面に移動する
	}
	
}
