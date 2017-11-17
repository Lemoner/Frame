package com.lmr.autocommand;

/**
 * Õ£÷π√¸¡Ó
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
