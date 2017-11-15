package com.icss.hr.pic.pojo;

import java.io.InputStream;
import java.util.Date;

/**
 * ͼƬʵ����
 * @author DLETC
 *
 */
public class Pic {
	private int picId;
	private String picName;
	private String picInfo;
	private long picSize;
	private String picAuthor;
	private InputStream picData;
	private Date picDatetime;
	
	
	public Pic() {
		super();
	}
	
	
	
	
	public Pic(String picName, String picInfo, long picSize, String picAuthor, InputStream picData, Date picDatetime) {
		super();
		this.picName = picName;
		this.picInfo = picInfo;
		this.picSize = picSize;
		this.picAuthor = picAuthor;
		this.picData = picData;
		this.picDatetime = picDatetime;
	}




	public Pic(int picId, String picName, String picInfo, long picSize, String picAuthor, InputStream picDate,
			Date picDatetime) {
		super();
		this.picId = picId;
		this.picName = picName;
		this.picInfo = picInfo;
		this.picSize = picSize;
		this.picAuthor = picAuthor;
		this.picData = picDate;
		this.picDatetime = picDatetime;
	}




	public int getPicId() {
		return picId;
	}
	public String getPicName() {
		return picName;
	}
	public String getPicInfo() {
		return picInfo;
	}
	public long getPicSize() {
		return picSize;
	}
	public String getPicAuthor() {
		return picAuthor;
	}
	public InputStream getPicData() {
		return picData;
	}
	public Date getPicDatetime() {
		return picDatetime;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public void setPicInfo(String picInfo) {
		this.picInfo = picInfo;
	}
	public void setPicSize(long picSize) {
		this.picSize = picSize;
	}
	@Override
	public String toString() {
		return "Pic [picId=" + picId + ", picName=" + picName + ", picInfo=" + picInfo + ", picSize=" + picSize
				+ ", picAuthor=" + picAuthor + ", picDate=" + picData + ", picDatetime=" + picDatetime + "]";
	}
	public void setPicAuthor(String picAuthor) {
		this.picAuthor = picAuthor;
	}
	public void setPicData(InputStream picDate) {
		this.picData = picDate;
	}
	public void setPicDatetime(Date picDatetime) {
		this.picDatetime = picDatetime;
	}
}
