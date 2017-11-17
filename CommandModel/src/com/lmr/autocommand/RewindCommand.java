package com.lmr.autocommand;

/**
 * µ¹´øÃüÁî
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
