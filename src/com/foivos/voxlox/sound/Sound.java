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
}
