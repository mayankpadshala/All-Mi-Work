package com.example.mind.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");
        arrayList.add("Data");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);
    }
}
