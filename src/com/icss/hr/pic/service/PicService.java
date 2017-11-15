package com.icss.hr.pic.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.pic.dao.PicDao;
import com.icss.hr.pic.pojo.Pic;

/**
 * ҵ���߼���
 * @author DLETC
 *
 */
public class PicService {
	
	private PicDao dao = new PicDao();
	
	public void addPic(Pic pic) throws SQLException {
		dao.insert(pic);
	}
	
	public List<Pic> queryPic() throws SQLException {
		return dao.query();
	}
	
	public Pic queryById(int picId) throws SQLException {
		return dao.queryById(picId);
	}
	
	public void deletePic(int picId) throws SQLException {
		dao.deletePic(picId);
	}
}
