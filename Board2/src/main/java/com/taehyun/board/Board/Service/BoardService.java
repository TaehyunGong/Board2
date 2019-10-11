package com.taehyun.board.Board.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.taehyun.board.Board.Vo.Board;

public interface BoardService {
	
	public List<Board> selectAllList();
	
	public Board selectDetailBoard(String boardNo);
	
	public boolean insertBoard(MultipartHttpServletRequest req);
}
