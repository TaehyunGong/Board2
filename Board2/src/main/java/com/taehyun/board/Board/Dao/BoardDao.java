package com.taehyun.board.Board.Dao;

import java.util.List;

import com.taehyun.board.Board.Vo.Board;

public interface BoardDao {

	public List<Board> selectAllBoardList();
}
