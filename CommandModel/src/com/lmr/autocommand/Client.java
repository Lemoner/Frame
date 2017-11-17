package com.lmr.autocommand;

public class Client {

	public static void main(String[] args) {
		
		AudioPlayer audioPlayer=new AudioPlayer();
		
		PlayCommand playCommand=new PlayCommand(audioPlayer);
		RewindCommand rewindCommand=new RewindCommand(audioPlayer);
		StopCommand stopCommand=new StopCommand(audioPlayer);
		MacroCommand macroCommand=new MacroCommand();
		
		KeyBoard keyBoard=new KeyBoard();
		
		keyBoard.setPlayCommand(playCommand);
		keyBoard.setRewindCommand(rewindCommand);
		keyBoard.setStopCommand(stopCommand);
		keyBoard.setMacroCommand(macroCommand);
		
		System.out.println("---------------");
		keyBoard.play();
		keyBoard.rewind();
		keyBoard.stop();
		keyBoard.rewind();
		
		macroCommand.add(playCommand);
		macroCommand.add(rewindCommand);
		macroCommand.add(stopCommand);
		macroCommand.add(playCommand);
		
		System.out.println("---------------");
		keyBoard.macro();
		
		macroCommand.remove(playCommand);
		System.out.println("---------------");
		keyBoard.macro();
		
	}
	
}
