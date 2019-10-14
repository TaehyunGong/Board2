package com.taehyun.board.Board.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.taehyun.board.Board.Dao.BoardDao;
import com.taehyun.board.Board.Vo.Board;
import com.taehyun.board.Common.FileLib;
import com.taehyun.board.Common.MapperVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	@Autowired
	FileLib fileLib;

	@Override
	public Map<String, Object> selectAllList(int pageNo) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNo", ((pageNo-1)*10)+1);
		map.put("lastNo", pageNo*10);
		
		Map<String, Object> result = new HashMap<String, Object>();
		//해당 페이지 넘버에 맞는 10개의 게시글
		result.put("list", dao.selectAllBoardList(map));
		//해당 페이지 넘버 반환
		result.put("pageNumbers", dao.selectPageNumbers(pageNo));
		
		return result;
	}

	@Override
	public Board selectDetailBoard(String boardNo) {
		MapperVo vo = new MapperVo("boardNo", boardNo);
		
		Board board =  dao.selectBoard(vo);
		
		//삭제된 글이라면 호출시 null객체로 반환
		if(board.getTitle() == null)
			board = null;
		
		return board;
	}

	@Override
	public boolean insertBoard(MultipartHttpServletRequest req) {
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		int boardNo = dao.selectMaxBoardNo();
		System.out.println("길이 : " + contents.length());
		Board board = new Board(); 
		board.setTitle(title);
		board.setContents(contents);
		board.setBoardNo(boardNo);
		
		dao.insertBoard(board);
		
		return false;
	}

	@Override
	public String editorImageUpload(MultipartHttpServletRequest req) throws IOException {
		MultipartFile file = req.getFile("image");
		return fileLib.uploadFile(file.getBytes(), file.getOriginalFilename());
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		//하나라도 UPDATE DELETE_DT = NOW()를 해주면 ture를 반환
		boolean result = (dao.deleteBoard(boardNo) >= 1) ? true : false;
		return result; 
	}

}
