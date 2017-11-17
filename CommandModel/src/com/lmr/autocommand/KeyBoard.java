package com.lmr.autocommand;

/**
 * �����ߣ�����
 */
public class KeyBoard {

	private PlayCommand playCommand;
	private RewindCommand rewindCommand;
	private StopCommand stopCommand;
	private MacroCommand macroCommand;

	public void setPlayCommand(PlayCommand playCommand) {
		this.playCommand = playCommand;
	}

	public void setRewindCommand(RewindCommand rewindCommand) {
		this.rewindCommand = rewindCommand;
	}

	public void setStopCommand(StopCommand stopCommand) {
		this.stopCommand = stopCommand;
	}
	
	public void setMacroCommand(MacroCommand macroCommand) {
		this.macroCommand = macroCommand;
	}

	/**
	 * ����
	 */
	public void play(){
		playCommand.execute();
	}
	
	/**
	 * ����
	 */
	public void rewind(){
		rewindCommand.execute();
	}
	
	/**
	 * ֹͣ
	 */
	public void stop(){
		stopCommand.execute();
	}
	
	/**
	 * ִ�к�����
	 */
	public void macro(){
		macroCommand.execute();
	}

}
