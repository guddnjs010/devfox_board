package org.zerock.domain;

import lombok.Data;

//@Data어노테이션을 추가해서 객체를 만들기위한 생성자, 겟터,셋터 역할을함
@Data
public class SampleDTO {

	
	private String name;
	private int age;
}
