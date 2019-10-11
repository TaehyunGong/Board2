package com.taehyun.board.Board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taehyun.board.Board.Dao.BoardDao;
import com.taehyun.board.Board.Vo.Board;
import com.taehyun.board.Common.MapperVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	@Override
	public List<Board> selectAllList() {
		return dao.selectAllBoardList();
	}

	@Override
	public Board selectDetailBoard(String boardNo) {
		MapperVo vo = new MapperVo("boardNo", boardNo);
		return dao.selectBoard(vo);
	}
	
	

}
