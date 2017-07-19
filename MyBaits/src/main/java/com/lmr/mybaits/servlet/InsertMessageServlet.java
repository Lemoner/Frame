package com.lmr.mybaits.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmr.mybaits.bean.Message;
import com.lmr.mybaits.service.InsertService;

/**
 * Ìí¼ÓMessage
 */
@SuppressWarnings("serial")
public class InsertMessageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String command=request.getParameter("command");
		String description=request.getParameter("description");
		String content=request.getParameter("content");
		
		Message message=new Message();
		message.setCommand(command);
		message.setDescription(description);
		message.setContent(content);
		
		InsertService insertService=new InsertService();
		insertService.insertMessage(message);
		
		request.getRequestDispatcher("/listMessageByPage.action").forward(request, response);
		
	}

}
