package com.example.android.miwok;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_colors);

        //Adding words to display
        ArrayList<Word> colors = new ArrayList<Word>();
        //words.add("one");
        colors.add(new Word("one", "lutti"));
        colors.add(new Word("two", "otiiko"));
        colors.add(new Word("three", "tolookosu"));
        colors.add(new Word("four", "oyyisa"));
        colors.add(new Word("five", "massokka"));
        colors.add(new Word("six", "temmokka"));
        colors.add(new Word("seven", "kenekaku"));
        colors.add(new Word("eight", "kawinta"));
        colors.add(new Word("nine", "wo'e"));
        colors.add(new Word("ten", "na'aacha"));

        WordAdapter colorsAdapter = new WordAdapter(this, colors);

        ListView colorsListView = (ListView) findViewById(R.id.color_list);

        colorsListView.setAdapter(colorsAdapter);


    }
}


