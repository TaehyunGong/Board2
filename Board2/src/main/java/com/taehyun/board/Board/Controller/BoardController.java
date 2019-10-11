package com.taehyun.board.Board.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
