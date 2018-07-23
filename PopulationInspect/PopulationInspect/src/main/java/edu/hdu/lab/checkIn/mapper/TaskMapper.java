package edu.hdu.lab.checkIn.mapper;

import java.util.List;

import edu.hdu.lab.checkIn.model.Police;
import edu.hdu.lab.checkIn.model.Task;

public interface TaskMapper {
	//查询所有条目
	public List<Task> queryAllTask();
	
	//查询单条数据
	public Task queryTaskById(int id);
	
	//添加数据
	public boolean addTask(Task task);
	
	//完成任务
	public boolean completeTask(int id);
	
	//删除数据
	public boolean deleteTask(int id);
	
	//客户端登陆
	public String mylogin(String username);
}