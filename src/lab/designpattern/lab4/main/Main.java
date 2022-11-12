package lab.designpattern.lab4.main;

import lab.designpattern.lab4.adapter.MediaPlayerAdapter;
import lab.designpattern.lab4.player.VlcPlayer;
import lab.designpattern.lab4.player.AudioPlayer;
import lab.designpattern.lab4.player.Mp4Player;

public class Main {

	public static void main(String[] args) {

		AudioPlayer audioPlayer = new AudioPlayer();
		VlcPlayer vlcPlayer = new VlcPlayer();
		Mp4Player mp4Player = new Mp4Player();

		audioPlayer.play();
		vlcPlayer.play();
		mp4Player.play();

		MediaPlayerAdapter adapter1 = new MediaPlayerAdapter(vlcPlayer);
		adapter1.play();

		MediaPlayerAdapter adapter2 = new MediaPlayerAdapter(mp4Player);
		adapter2.play();

	}

}
