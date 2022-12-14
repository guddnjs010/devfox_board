package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	//全体リスト
	//tbl_board　tableをBoardVo型のListに込めて見せてくるメソッド 
	List<BoardVO> getList();
	
	//掲示物登録
	//BoardVOをパラメータにしてDBにinsertする
	void insert(BoardVO board);
	
	void insertSelectKey(BoardVO board);
	
	//詳細画面
	//bnoをパラメータにして詳細に見られるメソッド
	BoardVO read(Long bno);
	
	//掲示物削除
	//bnoをパラメータにして掲示物を削除するメソッド
	int delete(Long bno);
	
	//修整(update)
	int update(BoardVO board);
	
	List<BoardVO> getListWithPaging(Criteria cri);
	
	int getTotalCount(Criteria cri);
	
	List<BoardVO> searchTest(Map<String, Map<String,String>> map);
}
