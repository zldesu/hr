package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * ����
 */
@WebServlet("/DownloadPicServlet")
public class DownloadPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ͼƬID
		String picId = request.getParameter("picId");
		//����ҵ�����
		PicService service = new PicService();
		Pic pic;
		try {
			//����ת��
			pic = service.queryById(Integer.parseInt(picId));
			String fileName = pic.getPicName();
			fileName = new String(fileName.getBytes(),"iso-8859-1");
			//������Ӧ��ͷ��֪ͨ�����
			response.setHeader("content-disposition", "attachment;filename=" + pic.getPicName());
			InputStream fis = pic.getPicData();
			OutputStream out = response.getOutputStream();
			byte[] b = new byte[1024 * 8];
			int len = fis.read(b);
			while(len != -1) {
				out.write(b,0,len);
				len = fis.read(b);
			}
			out.close();
			fis.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
