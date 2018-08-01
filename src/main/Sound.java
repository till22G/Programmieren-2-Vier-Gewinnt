package main;

import java.io.*;

import javax.sound.sampled.*;

public class Sound {
	
	private FloatControl volume;
	private static Clip clip;
	
	public Sound(String filename, boolean ambient) throws Exception {
		String musicFile = "../Programmieren-2-Vier-Gewinnt/src/Bilder/LeeresFeld.png";

		InputStream in = new FileInputStream(musicFile);
		BufferedInputStream bufferedIn = new BufferedInputStream(in);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);

		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

		if (ambient) {
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} else {
			clip.start();
		}

	}

	/**
	 * This function sets the volume corresponding to the slider bar in options.
	 * 
	 * @param value
	 *            The new value, from which the volume is calculated.
	 */
	public void setVolume(int value) {
		value = value / 10;
		this.volume.setValue(-24.0F + (value * 3.0F));
	}

	public static void startMusic() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stopMusic() {
		clip.stop();
	}

}
