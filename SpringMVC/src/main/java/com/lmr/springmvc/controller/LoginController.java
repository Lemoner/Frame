package com.lmr.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lmr.springmvc.Model.LoginBean;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/view")
	public String login(){
		return "login";
	}
	
	//�������
	@RequestMapping(value="/result1", method=RequestMethod.GET)
	public String login1(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model){
		
		System.out.println("login1 "+id+" - - "+pw);
		
		LoginBean loginbean=new LoginBean(id, pw);
//		model.addAttribute("loginbean", loginbean);
		
		//�������ֵĹ�����ʹ�ö����������Сдģʽ����model���֡������model�Ǽ��ϻ������ʱ��ʹ�ü��ϵĵ�һ��Ԫ�ص�������s����model�����֡�
		model.addAttribute(loginbean);
		
		return "loginsuccess";
	}
	
	@RequestMapping(value="/result2", method=RequestMethod.GET)
	public String login2(@RequestParam("id") String id, @RequestParam("pw") String pw, Map<String, Object> model){
		
		System.out.println("login2 "+id+" - - "+pw);
		
		LoginBean loginbean=new LoginBean(id, pw);
		model.put("loginbean",loginbean);
		
		return "loginsuccess";
	}
	
	//����·��
	@RequestMapping(value="/result3/{id}/", method=RequestMethod.GET)
	public String login3(@PathVariable("id") String id, Map<String, Object> model){
		
		System.out.println("login3 "+id);
		
		LoginBean loginbean=new LoginBean(id, "159258357456");
		model.put("loginbean",loginbean);
		
		return "loginsuccess";
	}
	
	@RequestMapping(value="/result4")
	public String login4(HttpServletRequest request){
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		LoginBean loginbean=new LoginBean(id, pw);
		
		request.setAttribute("loginbean", loginbean);
		
		return "loginsuccess";
	}
	
}
