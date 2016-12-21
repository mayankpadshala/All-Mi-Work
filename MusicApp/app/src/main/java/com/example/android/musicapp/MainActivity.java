package com.example.android.musicapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        final AudioManager mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        final int originalVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        Button playButton = (Button)findViewById(R.id.play_button);
        Button pauseButton = (Button)findViewById(R.id.pause_button);
        Button increaseVolume = (Button)findViewById(R.id.increase_volume);
        Button decreaseVolume = (Button)findViewById(R.id.decrease_volume);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    public void onCompletion(MediaPlayer mp) {

                        Log.i("Completion Listener","Song Complete");
                        //Toast.makeText(MainActivity.this , "I'm done", Toast.LENGTH_SHORT).show();
                        mediaPlayer.release();
                    }
                });
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();

            }
        });

        increaseVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
//                        AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                mAudioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            }
        });


        decreaseVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
//                        AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                mAudioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
            }
        });




    }
}
