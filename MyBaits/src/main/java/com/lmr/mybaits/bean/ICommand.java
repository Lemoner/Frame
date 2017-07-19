package com.lmr.mybaits.bean;

import java.util.List;

/**
 * Command表对应的接口
 */
public interface ICommand {

	public List<Command> queryCommandList(Command command);
	
}
