package com.lmr.autocommand;

/**
 * 接收者：录音机
 */
public class AudioPlayer {

	/**
	 * 录音机播放功能
	 */
	public void play(){
		System.out.println("AudioPlayer is play ...");
	}
	
	/**
	 * 录音机倒带功能
	 */
	public void rewind(){
		System.out.println("AudioPlayer is rewind ...");
	}
	
	/**
	 * 录音机停止功能
	 */
	public void stop(){
		System.out.println("AudioPlayer is stop !");
	}
	
}
