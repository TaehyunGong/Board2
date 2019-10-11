package com.taehyun.board.Board.Vo;

import java.util.Date;

public class Board {

	private int commentNo;
	private int boardNo;
	private int upComment;
	private String contents;
	private Date createDate;
	private Date modifyDate;
	private Date deleteDate;
	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int commentNo, int boardNo, int upComment, String contents, Date createDate, Date modifyDate,
			Date deleteDate) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.upComment = upComment;
		this.contents = contents;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getUpComment() {
		return upComment;
	}

	public void setUpComment(int upComment) {
		this.upComment = upComment;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	@Override
	public String toString() {
		return "Board [commentNo=" + commentNo + ", boardNo=" + boardNo + ", upComment=" + upComment + ", contents="
				+ contents + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", deleteDate=" + deleteDate
				+ "]";
	}
	
	
	
}
