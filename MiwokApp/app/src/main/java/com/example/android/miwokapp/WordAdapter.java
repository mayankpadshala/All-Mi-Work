package com.example.android.miwokapp;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mind on 12/12/16.
 */
public class WordAdapter extends ArrayAdapter<com.example.android.miwokapp.Word> {


    com.example.android.miwokapp.Word currentTranslation;
    private int mColorResourceId;
    //MediaPlayer mediaPlayer;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words          A List of Word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<com.example.android.miwokapp.Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.single_view, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
         currentTranslation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_translation);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentTranslation.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_translation);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(currentTranslation.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.corresponding_image);
        // Check if an image is provided for this word or not
        if (currentTranslation.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentTranslation.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }



        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Set the theme color for the list item
        View textContainer2 = listItemView.findViewById(R.id.text_container_2);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
//        textContainer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //To release any media player resources before another media player gets initialized
//                releaseMediaPlayer();
//                mediaPlayer = MediaPlayer.create(getContext(), currentTranslation.getAudioId());
//                mediaPlayer.start();
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//
//                    public void onCompletion(MediaPlayer mp) {
//
//                        //Log.i("Completion Listener","Song Complete");
//                        //Toast.makeText(getContext() , "I'm done", Toast.LENGTH_SHORT).show();
//                        releaseMediaPlayer();
//                    }
//                });
//            }
//        });
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        textContainer2.setBackgroundColor(color);




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

//
//    /**
//     * Clean up the media player by releasing its resources.
//     */
//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//
//            mediaPlayer.release();
//
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mediaPlayer = null;
//        }
//    }
//
//    protected void onStop() {
//
//        this.onStop();
//        //Log.v("MainActivity", "onStop");
//        releaseMediaPlayer();
//    }

}
