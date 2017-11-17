package com.lmr.autocommand;

/**
 * ��������
 */
public class RewindCommand implements Command{

	private AudioPlayer audioPlayer;
	
	public RewindCommand(AudioPlayer audioPlayer) {
		this.audioPlayer=audioPlayer;
	}
	
	@Override
	public void execute() {
		audioPlayer.rewind();
	}

}
