package com.example.android.viewpagerex;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the content of the mainActivity to use the activity_main.xml File
        setContentView(R.layout.activity_main);

        //Find the viewPager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        //Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        //Set the adapter on the view Pager
        viewPager.setAdapter(adapter);
    }
}
