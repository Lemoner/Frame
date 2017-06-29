package com.lmr.springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmr.springmvc.Model.ScoreBean;
import com.lmr.springmvc.service.ScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	
	private ScoreService scoreService;
	
	@Autowired
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	@RequestMapping(value="", method=RequestMethod.GET, params="add" )
	public String edit(){
		
		return "score/add";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(ScoreBean scoreBean,Model model){
		
		System.out.println(scoreBean.toString());
		
		model.addAttribute(scoreBean);
		
		return "score/result";
	}
	
	@RequestMapping(value="/save1", method=RequestMethod.POST)
	public String save1(Map<String, Object> model,String sname, String sid, String sgrade, int chinese, int math, int english){
		
		System.out.println(sname+" - - "+sid+" - - "+sgrade+" - - "+chinese+" - - "+math+" - - "+english);
		
		model.put("sname", sname);
		model.put("sid", sid);
		model.put("sgrade", sgrade);
		model.put("chinese", chinese);
		model.put("math", math);
		model.put("english", english);
		
//		return "score/result";
		//转发forward 重定向redirect
		return "forward:/score/save2";
	}
	
	@RequestMapping(value="/save2")
	public String save2(Map<String, Object> model){
		
		System.out.println(model.size());
		
		return "score/result";
	}
	
	@RequestMapping(value="/json1", method=RequestMethod.GET)
	public @ResponseBody List<ScoreBean> list1(){
		return scoreService.query();
	}
	
	@RequestMapping(value="/json2", method=RequestMethod.GET)
	public ResponseEntity<List<ScoreBean>> list2(){
		
		return new ResponseEntity<List<ScoreBean>>(scoreService.query(), HttpStatus.OK);
	}
	
}
