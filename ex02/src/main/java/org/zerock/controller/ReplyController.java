package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/*")
@Controller
@RequiredArgsConstructor
@Log4j
public class ReplyController {
	
	private final ReplyService replyService;
	
	@PostMapping("/register")
	public String replyRegister(ReplyVO vo, RedirectAttributes rttr) {
		int count = replyService.register(vo);
		
		rttr.addFlashAttribute("result", count);
		
		return "redirect:/board/get?bno="+vo.getBno();
		
	}
	
	@PostMapping("/modify")
	public String replyModify(ReplyVO vo, Criteria cri, RedirectAttributes rttr) {
		int count = replyService.modify(vo);
		
		rttr.addFlashAttribute("result", count);
		
		return "redirect:/board/get?bno="+vo.getBno();
		
	}
	
	@PostMapping("/remove")
	public String replyRemove(@RequestParam("bno") Long bno, @RequestParam("rno") Long rno, RedirectAttributes rttr ) {
		int count = replyService.remove(rno);
		
		rttr.addFlashAttribute("result", count);
		
		return "redirect:/board/get?bno="+bno;

	}
	


}
