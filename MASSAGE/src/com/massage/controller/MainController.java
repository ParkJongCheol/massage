package com.massage.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.massage.dao.LoginDAO;
import com.massage.dto.MemberDTO;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;

/**
 * Servlet implementation class LoginController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub	
		try{
			//Step1 - Using string funClass to convert to class
			//String funClass = "com.massage.service.LoginService";
			String funClass = request.getParameter("_actionName");
			Class c = Class.forName(funClass);
			
			//Step2 - instantiate an object of the class abov
			Object o = c.newInstance();
			//Prepare array of the arguments that your function accepts, lets say only one string here
			Class[] paramTypes = new Class[2];
			paramTypes[0]=HttpServletRequest.class;
			paramTypes[1]=HttpServletResponse.class;
			//String methodName = "Login";
			String methodName = request.getParameter("_methodName");
			//Instantiate an object of type method that returns you method name
			Method m = c.getDeclaredMethod(methodName, paramTypes);
			//invoke method with actual params
			m.invoke(o, request, response);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}

}
