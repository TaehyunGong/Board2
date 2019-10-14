package com.taehyun.board.Board.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taehyun.board.Board.Vo.Board;
import com.taehyun.board.Common.MapperVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession session;
	
	@Override
	public List<Board> selectAllBoardList() {
		return session.selectList("selectAllBoardList");
	}

	@Override
	public Board selectBoard(MapperVo vo) {
		return session.selectOne("selectBoard", vo);
	}

	@Override
	public int insertBoard(Board board) {
		return session.insert("insertBoard", board);
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

}
