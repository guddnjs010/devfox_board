package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {

	//掲示物登録
	void register(BoardVO board);
	
	//詳細画面
	BoardVO get(Long bno);
	
	//修整(update)
	int modify(BoardVO board);
	
	//掲示物削除
	int remove(Long bno);
	
	//全体リスト
	List<BoardVO> getList();
}
