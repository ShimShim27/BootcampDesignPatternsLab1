package lab.designpattern.lab4.main;

import lab.designpattern.lab4.adapter.MediaAdapter;
import lab.designpattern.lab4.base.MediaPlayer;
import lab.designpattern.lab4.player.AudioPlayer;
import lab.designpattern.lab4.player.Mp4Player;
import lab.designpattern.lab4.player.VLCPlayer;

public class AdapterPatternDemo {

	public static void main(String[] args) {

		VLCPlayer vlcPlayer = new VLCPlayer();
		Mp4Player mp4Player = new Mp4Player();
		
		MediaPlayer mediaPlayerWithMp4 = new AudioPlayer(new MediaAdapter(mp4Player));
		MediaPlayer mediaPlayerWithVLC = new AudioPlayer(new MediaAdapter(vlcPlayer));

		mediaPlayerWithMp4.play();
		System.out.println();
		mediaPlayerWithVLC.play();

	}

}
