package com.foivos.voxlox.sound;

import javax.sound.sampled.AudioFormat;

public class SoundUtils {

	private final static double volumeSamplingTime=0.01;
	
	public double[] getVolume(Sound sound) {
		AudioFormat audioFormat = sound.getFormat();
		//int sampleSizeInBytes= audioFormat.getSampleSizeInBits()/8;
		int volumeSamplingLength = (int) (audioFormat.getSampleRate() * volumeSamplingTime);
		int[] ints = sound.getIntArray();
		double[] volume = new double[ints.length];
		double avg = 0;
		for(int i=0;i<volumeSamplingLength/2;i++) {
			avg += (double)ints[i] / volumeSamplingLength;
		}
		for(int i=0;i<volume.length;i++) {
			volume[i] = avg;
			avg += (i+volumeSamplingLength/2 < volume.length) 
					? (double)ints[i+volumeSamplingLength/2] / volumeSamplingLength 	
					: 0;
			avg += (i-volumeSamplingLength/2 >= 0) 
					? (double)ints[i-volumeSamplingLength/2] / volumeSamplingLength 	
					: 0;		
		}
		return volume;
	}
}
