package com.lmr.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.lmr.springmvc.Model.ScoreBean;

@Service("scoreService")
public class ScoreService {

	public List<ScoreBean> query(){
		
		List<ScoreBean> scorelist=new ArrayList<>();
		for(int i=0;i<10;i++){
			ScoreBean scoreBean=new ScoreBean();
			Random rand=new Random();
			
			scoreBean.setSid((char)(rand.nextInt(26)+97)+"");
			scoreBean.setSname((char)(rand.nextInt(26)+97)+"");
			scoreBean.setSgrade((char)(rand.nextInt(26)+97)+"");
			scoreBean.setChinese(rand.nextInt(100));
			scoreBean.setMath(rand.nextInt(100));
			scoreBean.setEnglish(rand.nextInt(100));
			
			scorelist.add(scoreBean);
			
		}
		
		return scorelist;
	}
	
}
