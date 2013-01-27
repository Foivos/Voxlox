package com.foivos.voxlox.runnable;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.foivos.voxlox.graphical.GraphPane;
import com.foivos.voxlox.sound.Player;
import com.foivos.voxlox.sound.Recorder;
import com.foivos.voxlox.sound.Sound;
import com.foivos.voxlox.sound.SoundUtils;

public class Main {
	public static void main(String[] args) throws Exception{
		Sound sound = new Sound();
		Recorder.startRecording(sound);
		System.in.read();
		Recorder.stopRecording();
		Recorder.waitFor();
		Player.play(sound);
		
		int[] ints = sound.getIntArray();
		double[] data = new double[ints.length];
		for(int i=0;i<data.length;i++){
			data[i]=ints[i];
		}
		//JFrame frame1 = new JFrame();
		//GraphPane pane1 = new GraphPane(data);
		//frame1.add(pane1);
		//frame1.setPreferredSize(new Dimension(800,600));
		//frame1.setVisible(true);
		JFrame frame2 = new JFrame();
		GraphPane pane2 = new GraphPane(SoundUtils.getVolume(sound));
		frame2.add(pane2);
		frame2.setSize(new Dimension(800,600));
		frame2.setVisible(true);
	}
	
}
