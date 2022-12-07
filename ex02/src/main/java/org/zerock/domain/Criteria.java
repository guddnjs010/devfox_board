package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	//ページ番号
	private int pageNum;
	
	//ページずつ見せる数
	private int amount;
	
	//基本的にページは１、十個ずつ
	public Criteria() {
		this(1,10);
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
