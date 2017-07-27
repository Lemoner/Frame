package com.lmr.seckill.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lmr.seckill.dto.SeckillExecution;
import com.lmr.seckill.dto.SeckillExposer;
import com.lmr.seckill.dto.SeckillResult;
import com.lmr.seckill.entity.Seckill;
import com.lmr.seckill.enums.SeckillStateEnum;
import com.lmr.seckill.exception.SeckillCloseException;
import com.lmr.seckill.exception.SeckillRepeatException;
import com.lmr.seckill.service.SeckillService;

/**
 * 与秒杀相关的前端控制器
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController{
	
	/**
	 * 日志对象
	 */
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	/**
	 * 与秒杀相关的业务操作对象
	 */
	@Autowired
	private SeckillService seckillService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model){
		
		int offset=0;
		int limit=4;
		
		List<Seckill> seckills=seckillService.getSeckillAll(offset, limit);
		
		model.addAttribute("seckills", seckills);
		
		return "list";
	}
	
	@RequestMapping(value="/{seckillId}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId, Model model){
		
		if(seckillId==null){
			return "forward:/seckill/list";
		}
		
		Seckill seckill=seckillService.getSeckillById(seckillId);
		
		if(seckill==null){
			return "forward:/seckill/list";
		}
		
		model.addAttribute("seckill", seckill);
		
		return "detail";
	}
	
	@RequestMapping(value="/{seckillId}/exposer", method=RequestMethod.GET, produces={"application/json;chartset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExposer> exposer(@PathVariable("seckillId") Long seckillId){
		
		SeckillResult<SeckillExposer> result;
		
		try{
			SeckillExposer seckillExposer=seckillService.exportSeckillUrl(seckillId);
			result=new SeckillResult<SeckillExposer>(true, seckillExposer);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			result=new  SeckillResult<SeckillExposer>(false, e.getMessage());
		}
		
		return result;
		
	}
	
	@RequestMapping(value="/{seckillId}/{md5}/execution", method=RequestMethod.POST, produces={"application/json;chartset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExecution> execution(@PathVariable("seckillId") Long seckillId, @CookieValue(value="userPhone", required=false) Long userPhone, @PathVariable("md5") String md5){
		
		if(userPhone==null){
			return new SeckillResult<SeckillExecution>(false, SeckillStateEnum.NO_LOGIN.getInfor());
		}
		
		System.err.println(" - - - "+userPhone);
		
		SeckillResult<SeckillExecution> result;
		
		try{
			SeckillExecution seckillExecution=seckillService.executeSeckill(seckillId, userPhone, md5);
			result=new SeckillResult<SeckillExecution>(true, seckillExecution);
		} catch (SeckillCloseException e) {
			SeckillExecution seckillExecution=new SeckillExecution(seckillId, SeckillStateEnum.END);
			result=new SeckillResult<SeckillExecution>(true, seckillExecution);
		} catch (SeckillRepeatException e) {
			SeckillExecution seckillExecution=new SeckillExecution(seckillId, SeckillStateEnum.REPEAT_KILL);
			result=new SeckillResult<SeckillExecution>(true, seckillExecution);
		} catch (SecurityException e) {
			SeckillExecution seckillExecution=new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
			result=new SeckillResult<SeckillExecution>(true, seckillExecution);
		}
		
		return result;
		
	}
	
	@RequestMapping(value="/time/now", method=RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time(){
		Date nowTime=new Date();
		return new SeckillResult<Long>(true, nowTime.getTime());
	}
	
}
