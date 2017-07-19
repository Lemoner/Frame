package com.lmr.mybaits.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmr.mybaits.bean.Message;
import com.lmr.mybaits.service.QueryService;
import com.lmr.mybaits.util.Page;

/**
 * 分页列表页面初始化和查询控制
 */
@SuppressWarnings("serial")
public class ListMessageByPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		
		String command=request.getParameter("command");
		String description=request.getParameter("description");
		
		String currentPage=request.getParameter("currentPage");
		
		int cpage;
		if(currentPage!=null&&!currentPage.trim().equals("")){
			cpage=Integer.valueOf(currentPage);
		}
		else{
			cpage=1;
		}
		Page page=new Page();
		page.setCurrentPage(cpage);
		
		System.out.println(command+" - - "+description+" - - "+currentPage);
		
		QueryService queryService=new QueryService();
		List<Message> messageList=queryService.queryMessageListByPage(command, description, page);
		
		for(Message msg:messageList){
			System.out.println(msg.toString());
		}
		
		request.setAttribute("messageList", messageList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/jsp/back/list.jsp").forward(request, response);
		
	}

}
