package com.lmr.mybaits.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmr.mybaits.service.QueryService;

/**
 * 自动回复功能
 */
@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String command=request.getParameter("content");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		QueryService queryService=new QueryService();
//		pw.write(queryService.queryMessageByCommand(command));
		pw.write(queryService.queryCommandList(command, null));
		pw.flush();
		pw.close();
		
	}
}
