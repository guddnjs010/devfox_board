package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@Component
@ToString
@AllArgsConstructor
public class Restaurant {

	//필드주입
	@Autowired
	private Chef chef;
	
	/*
	 * Setter주입
	 @Setter(onMethod_ = {@Autowired} )
	 private Chef chef;
	 */
	
	/*
	 생성자 주입
	 @AllArgsConstructor추가 후
	 private Chef chef;
	 */
}
