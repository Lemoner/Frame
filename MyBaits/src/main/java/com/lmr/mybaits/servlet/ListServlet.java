package com.lmr.mybaits.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmr.mybaits.bean.Message;
import com.lmr.mybaits.service.QueryService;

/**
 * 列表页面初始化和查询控制
 *
 */

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String command=request.getParameter("command");
		String description=request.getParameter("description");
		
		QueryService queryService=new QueryService();
		List<Message> messageList=queryService.queryMessageList(command, description);
		
		for(Message msg:messageList){
			System.out.println(msg.toString());
		}
		
		request.setAttribute("messageList", messageList);
		request.getRequestDispatcher("WEB-INF/jsp/back/list.jsp").forward(request, response);
		
	}

}
