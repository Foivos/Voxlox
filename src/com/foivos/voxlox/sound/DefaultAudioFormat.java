package com.foivos.voxlox.sound;

import javax.sound.sampled.AudioFormat;

public class DefaultAudioFormat {
	
	private static float sampleRate = 44100;
	private static int sampleSizeInBits = 16;
	private static int channels = 1;
	private static boolean signed = true;
	private static boolean bigEndian = true;
	private static double recordingTime = 0.01;
	
	private static AudioFormat audioFormat = 
			new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	
	public static AudioFormat getFormat() {
		return audioFormat;
	}

	public static int getRecordingBufferSize() {
		int sampleSizeInBytes = sampleSizeInBits >> 3;
		return ((int) (sampleRate * recordingTime) / (sampleSizeInBytes))*sampleSizeInBytes;
	}
	
}
