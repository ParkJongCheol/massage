package com.massage.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.massage.dao.LoginDAO;
import com.massage.dto.MemberDTO;

public class LoginService {	
	
	public void Login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String userid = request.getParameter("userId");
		String password = request.getParameter("userId");
		
		MemberDTO memberDTO = new MemberDTO();
		LoginDAO loginDAO = new LoginDAO();
		
		memberDTO = loginDAO.Login(userid, password);
		
		request.setAttribute("member", memberDTO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ui/common/main.jsp");
		dispatcher.forward(request, response);
		
	}
}
