package edu.hdu.lab.checkIn.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.hdu.lab.checkIn.mapper.LogMapper;
import edu.hdu.lab.checkIn.mapper.TaskMapper;
import edu.hdu.lab.checkIn.model.Log;
import edu.hdu.lab.checkIn.utils.JsonUtils;

@Controller
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private LogMapper logMapper;
	
	@Autowired
	private TaskMapper taskMapper;
	
	@ResponseBody
	@RequestMapping(value = "/Log_list",produces = "text/html;charset=UTF-8")
	public String Log_list(@RequestParam("policeId") String policeId) { 
		//从请求中取得警员id,根据id查询其任务列表，再根据任务id查询相应的日志，此处返回所有日志

		List<Log> loglist = new ArrayList<Log>();
		loglist = logMapper.queryAllLog();

		return JsonUtils.createGson().toJson(loglist);       
    }

	@ResponseBody
	@RequestMapping(value = "/Log_add",produces = "text/html;charset=UTF-8")
	public boolean Log_add(@RequestParam("data") String dataList) { 
		System.out.println(dataList);
		JsonParser jp = new JsonParser();
		
		JsonElement je = jp.parse(dataList);
		
		JsonObject jo = je.getAsJsonObject();
		JsonArray jsonlist = jo.get("data").getAsJsonArray();
	
		for(int i =0;i<jsonlist.size();i++){
			jo = jsonlist.get(i).getAsJsonObject();
			Log l = new Log();
			l.setTaskId(jo.get("id").getAsInt());
			l.setContent(jo.get("content").getAsString());
			l.setDate(jo.get("date").getAsString());
			System.out.println(l.toString());
			logMapper.addLog(l);
			
			taskMapper.completeTask(jo.get("id").getAsInt());
		}

		return true;       
    }

	
}
