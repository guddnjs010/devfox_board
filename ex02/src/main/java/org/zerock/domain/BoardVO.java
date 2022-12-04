package org.zerock.domain;

import java.util.Date;

import lombok.Data;

//DBと繋がるオブジェクトクラス
//lombok -> getter, setter メソッド自動生成
@Data
public class BoardVO {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
}
