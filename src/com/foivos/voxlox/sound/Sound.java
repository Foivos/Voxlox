package com.foivos.voxlox.sound;

import java.io.ByteArrayOutputStream;

import javax.sound.sampled.AudioFormat;

public class Sound {
	private AudioFormat audioFormat;
	private ByteArrayOutputStream stream;
	public Sound(AudioFormat audioFormat) {
		this.audioFormat = audioFormat;
		stream = new ByteArrayOutputStream();
	}
	public Sound(){
		this(DefaultAudioFormat.getFormat());
	}
	public void append(byte[] bytes, int bytesRead) {
		stream.write(bytes, 0, bytesRead);
	}
	public AudioFormat getFormat() {
		return audioFormat;
	}
	public byte[] getByteArray() {
		return stream.toByteArray();
	}
	public int[] getIntArray() {
		byte[] bytes = getByteArray();
		int sampleSizeInBytes= audioFormat.getSampleSizeInBits()/8;
		int[] result = new int[bytes.length/sampleSizeInBytes];
		for(int i=0;i<bytes.length;i++) {
			result[i] = 0;
			for(int j=0;j<sampleSizeInBytes;j++){
				result[i] += bytes[i * sampleSizeInBytes + 
				                   (audioFormat.isBigEndian() ? j : (sampleSizeInBytes - 1 - j))];
			}
		}
		return result;
	}
	
}
