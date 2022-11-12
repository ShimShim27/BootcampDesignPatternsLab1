package lab.designpattern.lab4.adapter;

import lab.designpattern.lab4.base.AdvancedMediaPlayer;
import lab.designpattern.lab4.base.MediaPlayer;

public class MediaAdapter implements MediaPlayer {
	private AdvancedMediaPlayer advancedMediaPlayer;

	public MediaAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
		this.advancedMediaPlayer = advancedMediaPlayer;
	}

	@Override
	public void play() {
		this.advancedMediaPlayer.playMP4();
		this.advancedMediaPlayer.playVLC();

	}

}
