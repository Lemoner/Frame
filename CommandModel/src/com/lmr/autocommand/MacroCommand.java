package com.lmr.autocommand;

import java.util.ArrayList;
import java.util.List;

/**
 * ������
 */
public class MacroCommand implements Command {
	
	/**
	 * �����
	 */
	private List<Command> commandList=new ArrayList<>();
	
	/**
	 * �������
	 * @param command	����
	 */
	public void add(Command command){
		commandList.add(command);
	}
	
	/**
	 * ɾ������
	 * @param command	����
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
