package com.taehyun.board.Board.Dao;

import java.util.List;

import com.taehyun.board.Board.Vo.Board;
import com.taehyun.board.Common.MapperVo;

public interface BoardDao {

	public List<Board> selectAllBoardList();
	
	public Board selectBoard(MapperVo vo);
	
	public int insertBoard(Board board);
	
	public int selectMaxBoardNo();
	
	public int deleteBoard(int boardNo);
}
