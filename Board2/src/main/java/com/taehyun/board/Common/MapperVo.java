package com.taehyun.board.Common;

public class MapperVo {

	private String columeName;
	private String value;
	public MapperVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MapperVo(String columeName, String value) {
		super();
		this.columeName = columeName;
		this.value = value;
	}

	public String getColumeName() {
		return columeName;
	}
	public void setColumeName(String columeName) {
		this.columeName = columeName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "MapperVo [columeName=" + columeName + ", value=" + value + "]";
	}
	
	
}
