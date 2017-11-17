package com.lmr.autocommand;

import java.util.ArrayList;
import java.util.List;

/**
 * ºêÃüÁî
 */
public class MacroCommand implements Command {
	
	/**
	 * ÃüÁî¼¯ºÏ
	 */
	private List<Command> commandList=new ArrayList<>();
	
	/**
	 * Ìí¼ÓÃüÁî
	 * @param command	ÃüÁî
	 */
	public void add(Command command){
		commandList.add(command);
	}
	
	/**
	 * É¾³ıÃüÁî
	 * @param command	ÃüÁî
	 */
	public void remove(Command command){
		commandList.remove(command);
	}
	
	@Override
	public void execute() {
		for(Command command:commandList){
			command.execute();
		}
	}

}
