package com.example.android.miwokapp_2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Adding words to display
        final ArrayList<com.example.android.miwokapp_2.Word> words = new ArrayList<com.example.android.miwokapp_2.Word>();
        //words.add("one");
        words.add(new com.example.android.miwokapp_2.Word("Where are you going?", "minto wuksus" ,R.raw.phrase_where_are_you_going));
        words.add(new com.example.android.miwokapp_2.Word("What is your name", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new com.example.android.miwokapp_2.Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new com.example.android.miwokapp_2.Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new com.example.android.miwokapp_2.Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new com.example.android.miwokapp_2.Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new com.example.android.miwokapp_2.Word("yes I'm coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new com.example.android.miwokapp_2.Word("I'm coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new com.example.android.miwokapp_2.Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new com.example.android.miwokapp_2.Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter phrasesAdapter = new com.example.android.miwokapp_2.WordAdapter(this, words, R.color.category_phrases);

        ListView numberListView = (ListView) findViewById(R.id.list);

        numberListView.setAdapter(phrasesAdapter);

        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                releaseMediaPlayer();

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioId());

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
