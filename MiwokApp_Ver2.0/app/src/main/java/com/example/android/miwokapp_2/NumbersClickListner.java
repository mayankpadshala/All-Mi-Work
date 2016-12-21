package com.example.android.miwokapp_2;

import android.view.View;
import android.widget.Toast;

/**
 * Created by mind on 9/12/16.
 */
public class NumbersClickListner implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext() , "Open the List of Numbers", Toast.LENGTH_SHORT).show();
    }
}
