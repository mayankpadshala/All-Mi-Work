package com.example.android.miwokfragment;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mind on 15/12/16.
 */
public class FamilyFragment extends android.support.v4.app.Fragment {


    MediaPlayer mMediaPlayer;

    AudioManager am;

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ) {
                        // Pause playback and reset player to the start of the file so that the word plays from the begining
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        //Stop the playback and clean up the resources
                        releaseMediaPlayer();
//                        am.unregisterMediaButtonEventReceiver(RemoteControlReceiver);
//                        am.abandonAudioFocus(afChangeListener);
                        // Stop playback
                    }
                }
            };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_numbers, container, false);


        //Adding words to display
        final ArrayList<com.example.android.miwokfragment.Word> words = new ArrayList<com.example.android.miwokfragment.Word>();
        //words.add("one");
        words.add(new com.example.android.miwokfragment.Word("father", "әpә",R.drawable.family_father, R.raw.family_father));
        words.add(new com.example.android.miwokfragment.Word("mother", "әṭa",R.drawable.family_mother, R.raw.family_mother));
        words.add(new com.example.android.miwokfragment.Word("son", "angsi",R.drawable.family_son, R.raw.family_son));
        words.add(new com.example.android.miwokfragment.Word("daughter", "tune",R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new com.example.android.miwokfragment.Word("older brother", "taachi",R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new com.example.android.miwokfragment.Word("younger brother", "chalitti",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new com.example.android.miwokfragment.Word("older sister", "teṭe",R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new com.example.android.miwokfragment.Word("younger sister", "kolliti",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new com.example.android.miwokfragment.Word("grand mother", "ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new com.example.android.miwokfragment.Word("grand father", "paapa",R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter numberAdapter = new com.example.android.miwokfragment.WordAdapter(getActivity(), words, R.color.category_family);

        ListView numberListView = (ListView) rootView.findViewById(R.id.list);

        numberListView.setAdapter(numberAdapter);

        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                releaseMediaPlayer();

                //Request Audio Focus for the application
                int result = am.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //am.registerMediaButtonEventReceiver(RemoteControlReceiver);

                    //Setting the media player to start playing
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mMediaPlayer.release();
                            Toast.makeText(getActivity(), "Try Yourself", Toast.LENGTH_SHORT).show();
                        }
                    });
                    // Start playback.(The Above lines have gained audio focus)
                }


            }
        });


        return rootView;
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

            // Abandon audio focus when playback complete
            am.abandonAudioFocus(afChangeListener);
        }
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.v("MainActivity", "onPause");
//    }

    public void onStop() {
        super.onStop();
        //Log.v("MainActivity", "onStop");
        releaseMediaPlayer();
    }
}
