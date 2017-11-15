package com.icss.hr.common;

/**
 * 分页工具类
 * @author DLETC
 */
public class Page {
	private int recordCount;//总记录数
	
	private int pageSize = 10;//每页多少条
	
	private int pageCount;  //共几页
	
	private int pageNum;  //当前是第几页
	
	private int start;   //计算起始位置
	
	public Page(int recordCount,int pageSize,int pageNum) {
		this.recordCount = recordCount;
		this.pageSize= pageSize;
		this.pageNum = pageNum;
		
		//共几页
		this.pageCount = this.recordCount / this.pageSize;
		if(this.pageCount % this.pageSize != 0) {
			this.pageCount ++;
		}
		//计算当前页码
		if(this.pageNum < 1) 
			this.pageNum = 1;
		if(this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
			
		//计算起始位置
		this.start = (this.pageNum - 1) * this.pageSize + 1;
		
	}
	
	public Page(int recordCount,int pageNum) {
		this.recordCount = recordCount;
		this.pageNum = pageNum;
		
		//共几页
		this.pageCount = this.recordCount / this.pageSize;
		if(this.pageCount % this.pageSize != 0) {
			this.pageCount ++;
		}
		//计算当前页码
		if(this.pageNum < 1) 
			this.pageNum = 1;
		if(this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
			
		//计算起始位置
		this.start = (this.pageNum - 1) * this.pageSize + 1;
		
	}

	public int getRecordCound() {
		return recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStart() {
		return start;
	}
	
	public static void main(String[] args) {
		Page pg = new Page(22,10,1);
		System.out.println(pg.getStart());
	}
	
}
