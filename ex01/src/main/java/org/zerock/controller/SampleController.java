package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

//sample로 시작하는 url을 전부 이 컨트롤러가 가져옴 - servlet-context.xml에 pakage scan시켜야함
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@GetMapping("")
	public void basic() {
		log.info("basic......");
	}
	
	//sample/basicGET
	@GetMapping("basicGET")
	public void basicGET(){
		log.info("basic get......");
	}
	
	//SampleDTO의 객체를 만들어서 파라미터를 알아서 dto에 수집을 해줌
	//localhost:8081/sample/ex01?name=AAA&age=16으로 보내면 name과 age파라미터를 알아서 수집해줌
	@GetMapping("/ex01")
		public void ex01(SampleDTO dto) {
			log.info(dto);
		}
		
	
	@GetMapping("/ex02")
		public void ex02( @RequestParam("name") String name, int age) {
			log.info(name);
			log.info(age);
		}

	//파라미터를 리스트형태로 여러개 가져올수있음
		@GetMapping("/ex02List")
		public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
			log.info("ids : "+ ids);
			
			return "ex02List";
		}
	//localhost:8081/sample/ex02Bean?list%5B0%5D.name=AAA&list%5B0%5D.age=16
	//@ModelAttribute는 화면까지 전달하는 객체의 이름을 명시적으로 바꿔줌
	@GetMapping("/ex02Bean")
	public String ex02Bean( @ModelAttribute("sample") SampleDTOList list, Model model) {
		log.info(list);
		
		model.addAttribute("result", "success");
		
		return "sample/ex02Bean";
	}
	
	//리턴타입
	//void는 호출하는 URL과 동일한 이름의 JSP파일로 이동
	//String은 상황에 따라 다른 화면을 보여줄 때 사용, redirect, foward(거의사용안함)
	//redirect예제
	//re1을 호출하면 re1으로 갔다가 re2로 이동
	@GetMapping("/re1")
	public String re1() {
		log.info("re1------------");
		return "redirect:/sample/re2";
	}
	@GetMapping("/re2")
	public void re2() {
		log.info("re2------------");
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("exUpload");
	}
	
	//form에서 넘어오는 files 파라미터를 받아줌
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file -> {
			log.info(file.getOriginalFilename());
			log.info(file.getSize());
			log.info(file.getContentType());
		});
	}
	
}




