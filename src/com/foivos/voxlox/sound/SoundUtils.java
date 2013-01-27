package com.foivos.voxlox.sound;

import javax.sound.sampled.AudioFormat;

public class SoundUtils {

	private final static double volumeSamplingTime=0.1;
	
	public static double[] getVolume(Sound sound) {
		AudioFormat audioFormat = sound.getFormat();
		int volumeSamplingLength = (int) (audioFormat.getSampleRate() * volumeSamplingTime);
		int[] ints = sound.getIntArray();
		double[] volume = new double[ints.length];
		double avg = 0;
		for(int i=0;i<volumeSamplingLength/2;i++) {
			avg += (double)ints[i] / volumeSamplingLength;
		}
		for(int i=0;i<volume.length;i++) {
			volume[i] = avg;
			if(i+volumeSamplingLength/2 < volume.length) {
				double temp = (double)ints[i+volumeSamplingLength/2] / volumeSamplingLength;
				avg += temp * temp;
			}
			if(i-volumeSamplingLength/2 >= 0) {
				double temp = (double)ints[i-volumeSamplingLength/2] / volumeSamplingLength;	
				avg -= temp * temp;
			}
		}
		return volume;
	}
}
