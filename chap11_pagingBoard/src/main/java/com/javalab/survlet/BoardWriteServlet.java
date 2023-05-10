package com.javalab.survlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalab.dao.BoardDao;
import com.javalab.dto.BoardModel;


/**
 * 글 입력폼 보여주기 / 글저장 기능 서블릿
 */
@WebServlet("/boardWrite")
public class BoardWriteServlet extends HttpServlet {
	
	private static final long serivalVersionUID = 1L;
	// BoardDao 객체 참조값
	private BoardDao boardDao = BoardDao.getInstance();
	// 입력폼 띄워주는 메소드
 
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
	   // 컨텍스트 패스
	   String contextPath = request.getContextPath();
	   // 화면 입력폼으로 
	   //response.sendRedirect(contextPath + "/boardWriter.jsp");
	   
	   // [2] 이동 방식 forward : 어플리케이션 내에서 직접 이동
	   // request에 여러가지 정보를 담아서 이동해간 페이지에서 사용가능
	   RequestDispatcher dispatcher =
			   request.getRequestDispatcher("/boardWrite.jsp");
	   dispatcher.forward(request, response);
   }
   /*
    * 게시물 쓰기 화면에서 Post요청이 오면 처리하는 메소드
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   		throws ServletException, IOException {
	   
	   // 1. 사용자가 입력한 정보가 메시지 바디에 담겨오면 인코딩 필요
	   request.setCharacterEncoding("UTF-8");
	   
	   // 2. 사용자에게 보낼 컨텐츠의 인코딩 처리
	   response.setContentType("text/html; charset = utf-8");
	   
	   // 사용자 브라우저에 응답할 때 한글이 깨지지 않고 전달되도록 설정
	   response.setCharacterEncoding("utf-8");
	   
	   // 3. 전달받은 값으로 객체 생성
	   // boardWrite.jsp => "post"=>입력폼에서 넘어온 값으로 BoardModel 객체 생성
	   // 전달되는 parameter 명 : subject, writer, contents
	   BoardModel boardModel = new BoardModel();
	   boardModel.setSubject(request.getParameter("subject"));
	   boardModel.setWriter(request.getParameter("writer"));
	   boardModel.setContents(request.getParameter("contents"));
	   
	   // 4. Dao에 보내서 저장 작업 처리
	   boardDao.insert(boardModel);
	   
	   // 5. 컨텍스트 패스 얻기
	   String contextPath = request.getContextPath();
	   
	   // 6. 저장후 목록 보기로 이동하기 위해서 해당 서블릿 재요청
	   response.sendRedirect(contextPath + "/boardList");
   } // end do post
 }