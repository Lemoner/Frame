package com.lmr.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.lmr.springmvc.Model.LoginBean;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/view")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/viewencoding")
	public String loginnoencoding() {
		return "login_noencoding";
	}

	// �������
	@RequestMapping(value = "/result1", method = RequestMethod.GET)
	public String login1(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {

		System.out.println("login1 " + id + " - - " + pw);

		LoginBean loginbean = new LoginBean(id, pw);
		// model.addAttribute("loginbean", loginbean);

		// �������ֵĹ�����ʹ�ö����������Сдģʽ����model���֡������model�Ǽ��ϻ������ʱ��ʹ�ü��ϵĵ�һ��Ԫ�ص�������s����model�����֡�
		model.addAttribute(loginbean);

		return "loginsuccess";
	}

	@RequestMapping(value = "/result2", method = RequestMethod.GET)
	public String login2(@RequestParam("id") String id, @RequestParam("pw") String pw, Map<String, Object> model) {

		System.out.println("login2 " + id + " - - " + pw);

		LoginBean loginbean = new LoginBean(id, pw);
		model.put("loginbean", loginbean);

		return "loginsuccess";
	}

	// ����·��
	@RequestMapping(value = "/result3/{id}/", method = RequestMethod.GET)
	public String login3(@PathVariable("id") String id, Map<String, Object> model) {

		System.out.println("login3 " + id);

		LoginBean loginbean = new LoginBean(id, "159258357456");
		model.put("loginbean", loginbean);

		return "loginsuccess";
	}

	@RequestMapping(value = "/result4")
	public String login4(HttpServletRequest request) throws UnsupportedEncodingException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("login4 " + id + " - - " + pw);

		LoginBean loginbean = new LoginBean(id, pw);

		request.setAttribute("loginbean", loginbean);
		request.setAttribute("msg", "����Controller��msg");
		request.getSession().setAttribute("user", id);

		return "loginsuccess";
	}

	@RequestMapping(value = "/result5")
	public ModelAndView login5(@RequestParam("id") String id, @RequestParam("pw") String pw) {

		System.out.println("login5 " + id + " - - " + pw);
		
		LoginBean loginbean = new LoginBean(id, pw);

		ModelAndView mv=new ModelAndView();
		mv.addObject(loginbean);
		mv.setViewName("loginsuccess");
		
		return mv;

	}

}
