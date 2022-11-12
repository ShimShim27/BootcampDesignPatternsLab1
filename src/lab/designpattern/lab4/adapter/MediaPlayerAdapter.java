package lab.designpattern.lab4.adapter;

import lab.designpattern.lab4.base.AdvancedMediaPlayer;
import lab.designpattern.lab4.base.MediaPlayer;

public class MediaPlayerAdapter implements MediaPlayer {
	private AdvancedMediaPlayer advancedMediaPlayer;

	public MediaPlayerAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
		this.advancedMediaPlayer = advancedMediaPlayer;
	}

	@Override
	public void play() {
		System.out.print("Playing using MediaAdapter: ");
		this.advancedMediaPlayer.play();

	}

}
