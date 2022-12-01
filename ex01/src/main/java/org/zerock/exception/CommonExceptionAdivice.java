package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

//예외처리를 하는 어노테이션 (AOP : 비지니스로직은 아니나 반드시 필요한 예외 등을 분리하여 프로그래밍하는것)
@ControllerAdvice
@Log4j
public class CommonExceptionAdivice {

	//모든 예외를 Exception class를 통해 처리
	//view까지 데이터를 전달하기 위해 Model model 추가
	//예를 들어 SampleDTO의 age값은 int로 전달되어야 하나 다른 타입이 들어오면 예외가 발생하여 이 컨트롤러를 수행함
	@ExceptionHandler(Exception.class)
	public String execpt(Exception ex, Model model) {
		log.info("Exception..............."+ex.getMessage());
		model.addAttribute("exception", ex);
		log.info(model);
		
		return "/sample/error_page";
	}
}
