package com.foivos.voxlox.sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class Recorder {
	static TargetDataLine line;
	static boolean isRecording = false;
	static Object isDone = new Object();
	public static void startRecording(final Sound sound) throws LineUnsupportedException, LineUnavailableException{
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, 
		    sound.getFormat()); // format is an AudioFormat object
		if (!AudioSystem.isLineSupported(info)) {
		    throw new LineUnsupportedException();
		}
	    line = (TargetDataLine) AudioSystem.getLine(info);
	    line.open(sound.getFormat());
	    new Thread(new Runnable(){

			@Override
			public void run() {
				byte[] buffer = new byte[DefaultAudioFormat.getRecordingBufferSize()];
				int bytesRead=-1;
				line.start();
				while(bytesRead!=0) {
					bytesRead = line.read(buffer, 0, buffer.length);
					sound.append(buffer,bytesRead);
				}
				line.close();
				synchronized (isDone) {
					isDone.notify();
				}
			}
	    	
	    } , "Recording Thread").start();
	}
	
	public static void stopRecording() {
		line.stop();
	}

	public static void waitFor() throws InterruptedException {
		synchronized (isDone) {
		    isDone.wait();
		}
	}
}
