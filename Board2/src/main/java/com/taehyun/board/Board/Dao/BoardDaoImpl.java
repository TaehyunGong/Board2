package com.taehyun.board.Board.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taehyun.board.Board.Vo.Attachment;
import com.taehyun.board.Board.Vo.Board;
import com.taehyun.board.Common.MapperVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession session;

	@Override
	public List<Board> selectAllBoardList(Map<String, Integer> map) {
		return session.selectList("selectAllBoardList", map);
	}
	
	@Override
	public Map<String, Integer> selectPageNumbers(int pageNo) {
		return session.selectOne("selectPageNumbers", pageNo);
	}

	@Override
	public Board selectBoard(MapperVo vo) {
		return session.selectOne("selectBoard", vo);
	}
	
	@Override
	public int insertBoard(Board board){
		return session.insert("insertBoard", board);
	}
	
	@Override
	public int insertBoardAttach(Attachment attach) {
		return session.insert("insertBoardAttach", attach);
	}

	@Override
	public int selectMaxBoardNo() {
		int result = session.selectOne("selectMaxBoardNo");
		return result;
	}

	@Override
	public int deleteBoard(int boardNo) {
		return session.delete("deleteBoard", boardNo);
	}

	@Override
	public Attachment selectBoardAttach(int boardNo) {
		return session.selectOne("selectBoardAttach", boardNo);
	}

}
