package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@RequiredArgsConstructor
public class SampleHotel {

	//생성자 주입
	private final Chef chef;

	
	
}
