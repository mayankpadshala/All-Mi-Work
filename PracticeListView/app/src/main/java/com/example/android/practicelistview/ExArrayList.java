package com.example.android.practicelistview;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by mind on 13/12/16.
 */
public class ExArrayList {

    //For Storing String Demo 1
    private String mDemo1;

    //For Storing String Demo 2
    private String mDemo2;

    //For Storing Image Resource ID
    private int mImageResourceId;


    /**
     * Calling the constructor for ArrayList
     */
    public ExArrayList(String demo1, String demo2, int imageResourceId) {
        mDemo1 = demo1;
        mDemo2 = demo2;
        mImageResourceId = imageResourceId;
    }

    //Getting the value of String Demo1
    public String getDemo1() {
        return mDemo1;
    }

    //Getting the value of String Demo2
    public String getDemo2() {
        return mDemo2;
    }

    //Getting the Image Resource ID
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
