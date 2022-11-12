package lab.designpattern.lab4.player;

import lab.designpattern.lab4.adapter.MediaAdapter;
import lab.designpattern.lab4.base.MediaPlayer;

public class AudioPlayer implements MediaPlayer {
	private MediaAdapter mediaAdapter;

	public AudioPlayer() {

	}

	public AudioPlayer(MediaAdapter mediaAdapter) {
		this.mediaAdapter = mediaAdapter;
	}

	@Override
	public void play() {
		if (mediaAdapter == null) {
			System.out.println("Playing Mp3");
		} else {
			mediaAdapter.play();
		}

	}

}
