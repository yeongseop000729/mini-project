package com.javalab.survlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalab.dao.BoardDao;
import com.javalab.dto.BoardModel;

/**
 * 회원정보를 업데이트 하는 서블릿
 *
 */
@WebServlet("/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// boardView.jsp => "get" => parameter no 값을 저장할 객체
		// 전달되는 parameter 명 : no
		BoardModel boardModel=new BoardModel();
		int n = Integer.parseInt(request.getParameter("no"));
		boardModel.setNo(n);
		
		boardDao.delete(boardModel);
		
		response.sendRedirect("boardList");
		
	}

}