package com.example.android.viewpagerex;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mind on 15/12/16.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //Returns the page number to displat according to the swipes and also we define what to return;
        if (position == 0){
            return new First();
        } else if (position == 1){
            return new Second();
        } else {
            return new Third();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
