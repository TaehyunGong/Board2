package com.taehyun.board.Board.Vo;

import java.util.Date;

public class Board {

	private int boardNo;
	private String title;
	private String contents;
	private Date createDate;
	private Date modifyDate;
	private Date deleteDate;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNo, String title, String contents, Date createDate, Date modifyDate, Date deleteDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.contents = contents;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return "Board [boardNo=" + boardNo + ", title=" + title + ", contents=" + contents + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + ", deleteDate=" + deleteDate + "]";
	}
	
	
}
