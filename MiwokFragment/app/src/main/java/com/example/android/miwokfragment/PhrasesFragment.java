package com.example.android.miwokfragment;

import android.app.Fragment;
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
public class PhrasesFragment extends android.support.v4.app.Fragment {


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
        words.add(new com.example.android.miwokfragment.Word("Where are you going?", "minto wuksus" ,R.raw.phrase_where_are_you_going));
        words.add(new com.example.android.miwokfragment.Word("What is your name", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new com.example.android.miwokfragment.Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new com.example.android.miwokfragment.Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new com.example.android.miwokfragment.Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new com.example.android.miwokfragment.Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new com.example.android.miwokfragment.Word("yes I'm coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new com.example.android.miwokfragment.Word("I'm coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new com.example.android.miwokfragment.Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new com.example.android.miwokfragment.Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter phrasesAdapter = new com.example.android.miwokfragment.WordAdapter(getActivity(), words, R.color.category_phrases);

        ListView numberListView = (ListView) rootView.findViewById(R.id.list);

        numberListView.setAdapter(phrasesAdapter);

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
