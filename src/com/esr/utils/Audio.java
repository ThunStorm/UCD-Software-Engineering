package com.esr.utils;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @Description
 * @Author William
 * @Date 2020/12/8
 * @Version 1.0
 **/
public enum Audio {
    BGM("Bgm.wav"),
    TTO("3-2-1.wav"),
    GO("Go.wav"),
    FLOOD("FloodTiles.wav"),
    CAPTURE("Capture.wav"),
    SHOREUP("ShoreUp.wav"),
    PASSTO("PassTo.wav"),
    MOVETO("MoveTo.wav"),
    LIFTOFF("LiftOff.wav"),
    PLAYER1("Player 1.wav"),
    PLAYER2("Player 2.wav"),
    PLAYER3("Player 3.wav"),
    PLAYER4("Player 4.wav"),
    DISCARD("Discard.wav"),
    SPLASH("Splash.wav"),
    NEXT("Next.wav"),
    WIN("Wins!.wav"),
    FAILURE("Failure.wav");

    private final String name;

    Audio(String name) {
        this.name = name;
    }

    // play audio
    public void Play() {
        AudioStream as;
        try {
            InputStream resourceAsStream = Audio.class.getClassLoader().getResourceAsStream("com/esr/resources/audio/" + name);
            as = new AudioStream(Objects.requireNonNull(resourceAsStream));
            AudioPlayer.player.start(as);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // parameter sec is the duration of a audio to play
    public void LoopPlay(int sec) {
        CommonUtils.task(sec, () -> {
            try {
                InputStream resourceAsStream = Audio.class.getClassLoader().getResourceAsStream("com/esr/resources/audio/" + name);
                AudioStream as = new AudioStream(Objects.requireNonNull(resourceAsStream));
                AudioPlayer.player.start(as);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
