package com.example.mind.simplelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomArrayAdapterInplementation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CustomDataType> arrayList = new ArrayList<CustomDataType>();

        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));
        arrayList.add(new CustomDataType("Heading", "Description", R.mipmap.ic_launcher));

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(this, arrayList);

        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(customArrayAdapter);


    }
}
