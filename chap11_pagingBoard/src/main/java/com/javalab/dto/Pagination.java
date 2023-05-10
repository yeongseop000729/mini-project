package com.javalab.dto;

public class Pagination {
	
	private String pageNum = "1";
	private Integer listCount = 10;
	private Integer pagePerBlock = 10;
	
	public Pagination() {
		super();
		
	}

	public Pagination(String pageNum, Integer listCount, Integer pagePerBlock) {
		super();
		this.pageNum = pageNum;
		this.listCount = listCount;
		this.pagePerBlock = pagePerBlock;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getListCount() {
		return listCount;
	}

	public void setListCount(Integer listCount) {
		this.listCount = listCount;
	}

	public Integer getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(Integer pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	
	
	
	
	

}
