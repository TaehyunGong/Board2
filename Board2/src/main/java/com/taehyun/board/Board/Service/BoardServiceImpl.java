package com.taehyun.board.Board.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.taehyun.board.Board.Dao.BoardDao;
import com.taehyun.board.Board.Vo.Attachment;
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
		//첨부파일 가져오기.
		board.setAttachment(dao.selectBoardAttach(Integer.parseInt(boardNo)));
		
		//삭제된 글이라면 호출시 null객체로 반환
		if(board.getTitle() == null)
			board = null;
		
		return board;
	}

	@Transactional
	@Override
	public boolean insertBoard(MultipartHttpServletRequest req) throws Exception {
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		//현재 마지막 게시글 번호+1를 반환 
		int boardNo = dao.selectMaxBoardNo();
		
		Board board = new Board(); 
		board.setTitle(title);
		board.setContents(contents);
		board.setBoardNo(boardNo);
		
		//첨부파일이 없다면 게시글만 삽입
		if(req.getFile("file") == null) {
			//게시글 만 삽입
			if(dao.insertBoard(board) < 0) {
				throw new Exception();
			}
			
		}else {
			//첨부파일이 있다면 같이 삽입
			MultipartFile file = req.getFile("file");
			String uploadName = fileLib.uploadFile(file.getBytes(), file.getOriginalFilename());
			
			Attachment attach = new Attachment();
			attach.setAttachNo(1);
			attach.setBoardNo(boardNo);
			attach.setOriginFileName(file.getOriginalFilename());
			attach.setFileName(uploadName);
			attach.setFileSize(String.valueOf(file.getSize()));
			
			//게시글 및 첨부파일 
			if(dao.insertBoard(board) < 0 || dao.insertBoardAttach(attach) < 0) {
				throw new Exception();
			}
		}
	
		return true;
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

	@Override
	public HttpServletResponse downloadAttach(HttpServletRequest req, HttpServletResponse res) {
		String fileName = req.getParameter("fileName");
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		String realPath = fileLib.getFilePath();
		Attachment attach = dao.selectBoardAttach(boardNo);
		String originName = attach.getOriginFileName();
		
        try {
        	originName = URLEncoder.encode(originName, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("UnsupportedEncodingException");
        }
        
        realPath = realPath + fileName;
        System.out.println(realPath);
        
        // 파일명 지정        
        res.setContentType("application/octer-stream");
        res.setHeader("Content-Transfer-Encoding", "binary;");
        res.setHeader("Content-Disposition", "attachment; filename=\"" + originName + "\"");
        try {
            OutputStream os = res.getOutputStream();
            FileInputStream fis = new FileInputStream(realPath);
 
            int ncount = 0;
            byte[] bytes = new byte[512];
 
            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
		return res;
	}

}
