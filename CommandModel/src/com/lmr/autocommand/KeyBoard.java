package com.lmr.autocommand;

/**
 * 请求者：按键
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
	 * 播放
	 */
	public void play(){
		playCommand.execute();
	}
	
	/**
	 * 倒带
	 */
	public void rewind(){
		rewindCommand.execute();
	}
	
	/**
	 * 停止
	 */
	public void stop(){
		stopCommand.execute();
	}
	
	/**
	 * 执行宏命令
	 */
	public void macro(){
		macroCommand.execute();
	}

}
