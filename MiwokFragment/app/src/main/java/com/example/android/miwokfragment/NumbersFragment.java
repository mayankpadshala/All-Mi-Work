package com.example.android.miwokfragment;

import android.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
public class NumbersFragment extends android.support.v4.app.Fragment {



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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_numbers, container, false);


        am = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);


        //Adding words to display
        final ArrayList<com.example.android.miwokfragment.Word> words = new ArrayList<com.example.android.miwokfragment.Word>();
        //words.add("one");
        words.add(new com.example.android.miwokfragment.Word("one", "lutti",R.drawable.number_one, R.raw.number_one));
        words.add(new com.example.android.miwokfragment.Word("two", "otiiko",R.drawable.number_two, R.raw.number_two));
        words.add(new com.example.android.miwokfragment.Word("three", "tolookosu",R.drawable.number_three, R.raw.number_three));
        words.add(new com.example.android.miwokfragment.Word("four", "oyyisa",R.drawable.number_four, R.raw.number_four));
        words.add(new com.example.android.miwokfragment.Word("five", "massokka",R.drawable.number_five, R.raw.number_five));
        words.add(new com.example.android.miwokfragment.Word("six", "temmokka",R.drawable.number_six, R.raw.number_six));
        words.add(new com.example.android.miwokfragment.Word("seven", "kenekaku",R.drawable.number_seven, R.raw.number_seven));
        words.add(new com.example.android.miwokfragment.Word("eight", "kawinta",R.drawable.number_eight, R.raw.number_eight));
        words.add(new com.example.android.miwokfragment.Word("nine", "wo'e",R.drawable.number_nine, R.raw.number_nine));
        words.add(new com.example.android.miwokfragment.Word("ten", "na'aacha",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter numberAdapter = new com.example.android.miwokfragment.WordAdapter(getActivity(), words, R.color.category_numbers);

        ListView numberListView = (ListView) rootView.findViewById(R.id.list) ;

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
