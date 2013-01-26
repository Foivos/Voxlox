package com.foivos.voxlox.sound;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;

public class Sound {
	private AudioFormat audioFormat;
	private ByteArrayOutputStream stream;
	public Sound(AudioFormat audioFormat) {
		this.audioFormat = audioFormat;
	}
	public Sound(){
		this(DefaultAudioFormat.getFormat());
	}
	public void append(byte[] bytes) {
		try {
			stream.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public AudioFormat getFormat() {
		return audioFormat;
	}
	public byte[] getByteArray() {
		return stream.toByteArray();
	}
}
