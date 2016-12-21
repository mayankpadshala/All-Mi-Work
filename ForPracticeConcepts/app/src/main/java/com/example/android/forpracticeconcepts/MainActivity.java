package com.example.android.forpracticeconcepts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openListViewAndAdapters(View view) {

        //Find the TextView with id listview_and_adapters
        TextView listViewAndAdapters = (TextView) findViewById(R.id.listview_and_adapters);

        //Implement the set onClickListner method on the listViewAndAdapters object
        listViewAndAdapters.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Create an Intent for the ListViewAndAdapters Activity
                Intent intent = new Intent(MainActivity.this, ListViewAndAdapters.class);

                //Start the Activity
                startActivity(intent);
            }
        });
    }

    public void openCustomListViewAndAdapters(View view) {
        //Find the textview with id custom_listview_and_adapters
        TextView customListViewAndAdapters = (TextView) findViewById(R.id.custom_listview_and_adapters);

        customListViewAndAdapters.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , CustomListViewAndAdapters.class);
                startActivity(i);
            }
        });
    }
}
