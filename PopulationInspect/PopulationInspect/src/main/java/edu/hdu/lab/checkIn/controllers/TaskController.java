package edu.hdu.lab.checkIn.controllers;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.hdu.lab.checkIn.mapper.TaskMapper;
import edu.hdu.lab.checkIn.model.Task;
import edu.hdu.lab.checkIn.mapper.PoliceMapper;
import edu.hdu.lab.checkIn.utils.JsonUtils;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private PoliceMapper policeMapper;
	
	
	//获取任务列表
	@ResponseBody
	@RequestMapping(value = "/Task_all",produces = "text/html;charset=UTF-8")
	public String Task_all() {	
		List<Task> list = new ArrayList<Task>();
		list = taskMapper.queryAllTask();
		return JsonUtils.createGson().toJson(list);
	}
	
	//根据警员id获取任务列表
	@ResponseBody
	@RequestMapping(value = "/Task_list",produces = "text/html;charset=UTF-8")
	public String Task_list(@RequestParam("policeId") String policeId) {
		//根据警员编号获取任务列表,理论上应在dao层加一个根据警员id获取数据的方法，为了偷懒先全部获取，然后遍历抽取具有该警员id的任务
		List<Task> result = new ArrayList<Task>();
		
		List<Task> list = new ArrayList<Task>();
		list = taskMapper.queryAllTask();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getPoliceId().equals(policeId)){
				result.add(list.get(i));
			}
		}
		
		return JsonUtils.createGson().toJson(result);
	}
	
	//添加任务
	@ResponseBody
	@RequestMapping(value = "/Task_add",produces = "text/html;charset=UTF-8")
	public String Task_add(@RequestParam("data") String dataList) { 
		System.out.println("任务列表："+dataList);
		
		Format format = new SimpleDateFormat("HHmmss");
		System.out.println(format.format(new Date()));
		
		JsonParser jp = new JsonParser();	
		JsonElement je = jp.parse(dataList);

		JsonArray jsonlist = je.getAsJsonArray();
		
		for(int i =0;i<jsonlist.size();i++){
			JsonObject jo = jsonlist.get(i).getAsJsonObject();
			Task task = new Task();
			task.setTaskId(Integer.parseInt(format.format(new Date())+i));
			task.setLatitude(jo.get("latitude").getAsDouble());
			task.setLongitude(jo.get("longitude").getAsDouble());
			task.setPoliceId(jo.get("policeCode").getAsString());
			String policeName = policeMapper.getNameById(jo.get("policeId").getAsInt());
			task.setPoliceName(policeName);
			task.setDeadLine(jo.get("deadLine").getAsString());
			task.setCommunity(jo.get("community").getAsString());
			task.setRoom(jo.get("room").getAsString());
			task.setType(jo.get("type").getAsString());
			task.setState(0);
			task.setContent(jo.get("content").getAsString());

			taskMapper.addTask(task);
		}

		return JsonUtils.createGson().toJson("true");   
    }
	
	//完成任务
		@ResponseBody
		@RequestMapping(value = "/Task_complete",produces = "text/html;charset=UTF-8")
		public String Task_complete() { 
			return JsonUtils.createGson().toJson(taskMapper.completeTask(1));
	    }

	//客户端登陆
		@ResponseBody
		@RequestMapping(value = "/myLogin",produces = "text/html;charset=UTF-8")
		public String myLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
			Boolean result = false;
			
			System.out.println(username+";"+password);

			if(taskMapper.mylogin(username)!=null && taskMapper.mylogin(username).equals(password)){
				result = true;
			}
			
			return JsonUtils.createGson().toJson(result);
		}
}
