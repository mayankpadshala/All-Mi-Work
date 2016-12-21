package com.example.android.miwokapp_2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Adding words to display
        final ArrayList<com.example.android.miwokapp_2.Word> words = new ArrayList<com.example.android.miwokapp_2.Word>();
        //words.add("one");
        words.add(new com.example.android.miwokapp_2.Word("father", "әpә",R.drawable.family_father, R.raw.family_father));
        words.add(new com.example.android.miwokapp_2.Word("mother", "әṭa",R.drawable.family_mother, R.raw.family_mother));
        words.add(new com.example.android.miwokapp_2.Word("son", "angsi",R.drawable.family_son, R.raw.family_son));
        words.add(new com.example.android.miwokapp_2.Word("daughter", "tune",R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new com.example.android.miwokapp_2.Word("older brother", "taachi",R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new com.example.android.miwokapp_2.Word("younger brother", "chalitti",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new com.example.android.miwokapp_2.Word("older sister", "teṭe",R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new com.example.android.miwokapp_2.Word("younger sister", "kolliti",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new com.example.android.miwokapp_2.Word("grand mother", "ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new com.example.android.miwokapp_2.Word("grand father", "paapa",R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter numberAdapter = new com.example.android.miwokapp_2.WordAdapter(this, words, R.color.category_family);

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
                mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, word.getAudioId());

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

