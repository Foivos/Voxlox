package com.foivos.voxlox.sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Player {
	static SourceDataLine line;
	public static void play(Sound sound) throws LineUnsupportedException, LineUnavailableException {
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, 
		    sound.getFormat()); // format is an AudioFormat object
		if (!AudioSystem.isLineSupported(info)) {
		    throw new LineUnsupportedException();
		}
	    line = (SourceDataLine) AudioSystem.getLine(info);
	    line.open(sound.getFormat());
	    line.start();
	    byte[] bytes = sound.getByteArray();
	    line.write(bytes, 0, bytes.length);
	}
}
