package com.lmr.mybaits.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmr.mybaits.service.DeleteService;

/**
 * É¾³ýµ¥¸öMessage
 */
@SuppressWarnings("serial")
public class DeleteMessageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.doPost(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String id=request.getParameter("id");
		String id=request.getParameter("deleteid");
		DeleteService deleteService=new DeleteService();
		deleteService.deleteMessage(id);
		
		request.getRequestDispatcher("/list.action").forward(request, response);

	}

}
