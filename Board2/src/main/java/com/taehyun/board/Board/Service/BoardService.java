package com.taehyun.board.Board.Service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.taehyun.board.Board.Vo.Board;

public interface BoardService {
	
	public Map<String, Object> selectAllList(int pageNo);
	
	public Board selectDetailBoard(String boardNo);
	
	public boolean insertBoard(MultipartHttpServletRequest req) throws Exception;
	
	public String editorImageUpload(MultipartHttpServletRequest req) throws IOException ;
	
	public boolean deleteBoard(int boardNo);
	
	public HttpServletResponse downloadAttach(HttpServletRequest req, HttpServletResponse res) throws Exception ;
}
