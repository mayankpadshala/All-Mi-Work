package com.example.android.practicelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an ArrayList of ExArrayList objects
        ArrayList<ExArrayList> exArrayLists = new ArrayList<ExArrayList>();

        //Below add the contents in the exArrayList ArrayList so that it can be displayed
        exArrayLists.add(new ExArrayList("FIRST", "first", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("SECOND", "second", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("THIRD", "third", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("FOURTH", "fourth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("FIFTH", "fifth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("SIXTH", "sixth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("SEVENTH", "seventh", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("EIGHTH", "eighth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("NINTH", "ninth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("TENTH", "tenth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("ELEVENTH", "eleventh", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("TWELVETH", "twelveth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("THIRTEENTH", "thirhteenth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("FOURTEENTH", "fourteenth", R.mipmap.ic_launcher));
        exArrayLists.add(new ExArrayList("FIFTEENTH", "fifteenth", R.mipmap.ic_launcher));

        /**
         * Create an object of type ExArrayListAdapter whose data source is the list of exArrayLists
         * The ExArrayListAdapter knows how to display the data that it gets from the source we provided
         */

        ExArrayListAdapter exAdapter = new ExArrayListAdapter(this, exArrayLists);


        //Get a reference of the listview and attach it to the Adapter
        ListView listView = (ListView) findViewById(R.id.list_view_ex);
        listView.setAdapter(exAdapter);




    }
}
