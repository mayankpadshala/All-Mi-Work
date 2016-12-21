package com.example.android.forpracticeconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewAndAdapters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_and_adapters);

        ArrayList<String> example = new ArrayList<String>();

        example.add("One");
        example.add("Two");
        example.add("Three");
        example.add("Four");
        example.add("Five");
        example.add("One");
        example.add("Two");
        example.add("Three");
        example.add("Four");
        example.add("Five");
        example.add("One");
        example.add("Two");
        example.add("Three");
        example.add("Four");
        example.add("Five");
        example.add("One");
        example.add("Two");
        example.add("Three");
        example.add("Four");
        example.add("Five");

        ArrayAdapter<String> exampleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, example);

        ListView listView = (ListView) findViewById(R.id.simple_listview);
        listView.setAdapter(exampleAdapter);
    }
}
