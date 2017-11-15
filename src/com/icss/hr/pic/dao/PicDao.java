package com.icss.hr.pic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DBUtil;
import com.icss.hr.pic.pojo.Pic;

/**
 * 图片dao
 * @author DLETC
 *
 */
public class PicDao {
	
	/**
	 * 插入数据
	 * @throws SQLException 
	 */
	public void insert(Pic pic) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into pic values (pic_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pic.getPicName());
		pstmt.setString(2, pic.getPicInfo());
		pstmt.setLong(3, pic.getPicSize());
		pstmt.setString(4, pic.getPicAuthor());
		pstmt.setBinaryStream(5, pic.getPicData(),(int)pic.getPicSize());//必须传入数据流大小
		pstmt.setTimestamp(6, new Timestamp(pic.getPicDatetime().getTime()));
		pstmt.executeUpdate();
		pstmt.close();
		pstmt.close();
	}
	
	/**
	 * 返回图片集合
	 * @throws SQLException 
	 */
	public List<Pic> query() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from pic order by pic_datetime desc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Pic> list = new ArrayList<>();
		Pic pic = null;
		while(rs.next()) {
			pic = new Pic(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),
					rs.getString(5),null,rs.getTimestamp(7));
			
			list.add(pic);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
	/**
	 * 根据id返回图片二进制数据
	 * @throws SQLException 
	 */
	public Pic queryById(int picId) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from pic where pic_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, picId);
		
		ResultSet rs = pstmt.executeQuery();
		
		Pic pic = null;
		if(rs.next()) {
			pic = new Pic();
			
			pic.setPicName(rs.getString(2));
			pic.setPicData(rs.getBinaryStream(6));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return pic;
	}
	
	
	
	
	
	
	
	
	/**
	 * 删除图片
	 * @throws SQLException 
	 */
	public void deletePic(int empId) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from Pic where pic_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, empId);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	
	
}
