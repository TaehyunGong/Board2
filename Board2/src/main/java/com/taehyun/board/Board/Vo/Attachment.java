package com.taehyun.board.Board.Vo;

import java.util.Date;

public class Attachment {
	
	private int attachNo;
	private int boardNo;
	private String fileName;
	private String originFileName;
	private String fileSize;
	private Date createDate;
	private Date modifyDate;
	private Date deleteDate;
	public Attachment() {
	}
	public Attachment(int attachNo, int boardNo, String fileName, String originFileName, String fileSize,
			Date createDate, Date modifyDate, Date deleteDate) {
		super();
		this.attachNo = attachNo;
		this.boardNo = boardNo;
		this.fileName = fileName;
		this.originFileName = originFileName;
		this.fileSize = fileSize;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
	}
	public int getAttachNo() {
		return attachNo;
	}
	public void setAttachNo(int attachNo) {
		this.attachNo = attachNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
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
		return "Attachment [attachNo=" + attachNo + ", boardNo=" + boardNo + ", fileName=" + fileName
				+ ", originFileName=" + originFileName + ", fileSize=" + fileSize + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", deleteDate=" + deleteDate + "]";
	}
	
	
	
}
