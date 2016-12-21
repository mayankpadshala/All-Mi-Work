package com.example.android.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Adding words to display
        final ArrayList<com.example.android.miwokapp.Word> words = new ArrayList<com.example.android.miwokapp.Word>();
        //words.add("one");
        words.add(new com.example.android.miwokapp.Word("red", "weṭeṭṭi",R.drawable.color_red, R.raw.color_red));
        words.add(new com.example.android.miwokapp.Word("green", "chokokki",R.drawable.color_green, R.raw.color_green));
        words.add(new com.example.android.miwokapp.Word("brown", "ṭakaakki",R.drawable.color_brown, R.raw.color_brown));
        words.add(new com.example.android.miwokapp.Word("gray", "ṭopoppi",R.drawable.color_gray, R.raw.color_gray));
        words.add(new com.example.android.miwokapp.Word("black", "kululli",R.drawable.color_black, R.raw.color_black));
        words.add(new com.example.android.miwokapp.Word("white", "kelelli",R.drawable.color_white, R.raw.color_white));
        words.add(new com.example.android.miwokapp.Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new com.example.android.miwokapp.Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter numberAdapter = new com.example.android.miwokapp.WordAdapter(this, words, R.color.category_colors);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(numberAdapter);

        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                releaseMediaPlayer();

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioId());

                // Start the audio file
                mMediaPlayer.start();
                releaseMediaPlayer();
            }
        });

    }


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.

            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    protected void onStop() {

        super.onStop();
        //Log.v("MainActivity", "onStop");
        releaseMediaPlayer();
    }


}

