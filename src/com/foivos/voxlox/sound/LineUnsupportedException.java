package com.foivos.voxlox.sound;

public class LineUnsupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LineUnsupportedException() {
		super("The Audio System does not support the data line");
	}
	
}
