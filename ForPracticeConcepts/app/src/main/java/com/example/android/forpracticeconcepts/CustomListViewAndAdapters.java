package com.example.android.forpracticeconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewAndAdapters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view_and_adapters);

        ArrayList<CustomArrayListType> arrayListTypes = new ArrayList<CustomArrayListType>();

        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));
        arrayListTypes.add(new CustomArrayListType("Color", "Hash Code", R.mipmap.ic_launcher));

        CustomArrayAdapter adapter = new CustomArrayAdapter(this, arrayListTypes);

        ListView listView = (ListView) findViewById(R.id.custom_listview_adapters);
        listView.setAdapter(adapter);


    }
}
