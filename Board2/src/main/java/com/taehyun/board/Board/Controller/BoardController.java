package com.taehyun.board.Board.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.taehyun.board.Board.Service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	//모든 게시글 리스트 조회
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public ModelAndView boardAllList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/board/list");
		mav.addObject("list", service.selectAllList());
		return mav;
	}
	
	//게시글 상세 조회
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView boardDetail(@RequestParam String boardNo) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/board/detail");
		mav.addObject("board", service.selectDetailBoard(boardNo));
		return mav;
	}	
	
	//글 작성 페이지로 이동
	@RequestMapping(value="/writeBoard")
	public ModelAndView writeBoard() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/write");
		return mav;
	}
	
	//작성한 글 insert
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(MultipartHttpServletRequest req) {
		service.insertBoard(req);
		
		return "redirect:/board";
	}
	
	//썸머노트에서 이미지 업로드시 저장
	@RequestMapping(value="/editorImageUpload", method=RequestMethod.POST)
	public @ResponseBody String editorImageUpload(MultipartHttpServletRequest req) throws IOException {
		String uploadFileName = service.editorImageUpload(req);
		//현재 도메인을 따로 잡지 않았기 때문에 포트까지 붙혀주어야한다..
		return req.getServerName()+":"+req.getServerPort()+"/upload/"+uploadFileName;
	}
}
