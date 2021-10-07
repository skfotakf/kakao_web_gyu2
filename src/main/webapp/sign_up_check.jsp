<%@page import="com.kakao.web.dao.SignUpDaoImpl"%>
<%@page import="com.kakao.web.dao.SignUpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String submit_flag = request.getParameter("submit_flag");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	
	if(submit_flag.equals("1")) {
		// 가입요청
		
	} else if(submit_flag.equals("2")) {
		// 전화번호 인증요청
		SignUpDao signUpDao = new SignUpDaoImpl();
		int flag = signUpDao.phoneNumberCheck(phone,name);
		
		
%>
			<jsp:forward page="sign_up_phone.jsp">
				<jsp:param value="<%= flag%>" name="flag"/>
			</jsp:forward>			
<%
	}
%>