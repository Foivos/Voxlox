package com.foivos.voxlox.runnable;

import com.foivos.voxlox.sound.Player;
import com.foivos.voxlox.sound.Recorder;
import com.foivos.voxlox.sound.Sound;

public class Main {
	public static void main(String[] args) throws Exception{
		Sound sound = new Sound();
		Recorder.startRecording(sound);
		System.in.read();
		Recorder.stopRecording();
		Recorder.waitFor();
		Player.play(sound);
	}
	
}
