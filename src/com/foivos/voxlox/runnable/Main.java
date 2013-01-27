package com.foivos.voxlox.runnable;

import javax.swing.JFrame;

import com.foivos.voxlox.graphical.GraphPane;

public class Main {
	public static void main(String[] args) throws Exception{
		/*Sound sound = new Sound();
		Recorder.startRecording(sound);
		System.in.read();
		Recorder.stopRecording();
		Recorder.waitFor();
		Player.play(sound);*/
		
		JFrame frame = new JFrame();
		GraphPane pane = new GraphPane();
		frame.add(pane);
		frame.setVisible(true);
	}
	
}
