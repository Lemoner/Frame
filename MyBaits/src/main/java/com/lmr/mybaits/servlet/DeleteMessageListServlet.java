package com.lmr.mybaits.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmr.mybaits.service.DeleteService;

/**
 * É¾³ý¶à¸ömessage
 */
@SuppressWarnings("serial")
public class DeleteMessageListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.doPost(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] ids=request.getParameterValues("checkbox");
		DeleteService deleteService=new DeleteService();
		deleteService.deleteMessageList(ids);
		
		request.getRequestDispatcher("/list.action").forward(request, response);

	}
}
