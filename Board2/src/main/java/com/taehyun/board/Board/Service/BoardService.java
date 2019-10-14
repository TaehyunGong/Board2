package com.taehyun.board.Board.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.taehyun.board.Board.Vo.Board;

public interface BoardService {
	
	public List<Board> selectAllList(int pageNo);
	
	public Board selectDetailBoard(String boardNo);
	
	public boolean insertBoard(MultipartHttpServletRequest req);
	
	public String editorImageUpload(MultipartHttpServletRequest req) throws IOException ;
	
	public boolean deleteBoard(int boardNo);
}
