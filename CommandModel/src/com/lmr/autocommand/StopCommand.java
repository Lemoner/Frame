package com.lmr.autocommand;

/**
 * ֹͣ����
 */
public class StopCommand implements Command {

	private AudioPlayer audioPlayer;
	
	public StopCommand(AudioPlayer audioPlayer) {
		this.audioPlayer=audioPlayer;
	}
	
	@Override
	public void execute() {
		audioPlayer.stop();
	}

}
