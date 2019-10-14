package com.taehyun.board.Board.Dao;

import java.util.List;
import java.util.Map;

import com.taehyun.board.Board.Vo.Attachment;
import com.taehyun.board.Board.Vo.Board;
import com.taehyun.board.Common.MapperVo;

public interface BoardDao {

	public List<Board> selectAllBoardList(Map<String, Integer> map);
	
	public Map<String, Integer> selectPageNumbers(int pageNo);
	
	public Board selectBoard(MapperVo vo);
	
	public int insertBoard(Board board);
	
	public int insertBoardAttach(Attachment attach);
	
	public int selectMaxBoardNo();
	
	public int deleteBoard(int boardNo);
	
	public Attachment selectBoardAttach(int boardNo);
	
}
