package com.example.android.fragmentex;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mind on 15/12/16.
 */
public class MyFragment extends Fragment {

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.v("MyFragment","On Attach Activity" );
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MyFragment","On Create savedInstanceState" );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v("MyFragment", "onCreateView Called");
        return inflater.inflate(R.layout.my_fragment_layout, container, false);

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("MyFragment", "onActivtyCreated Called");
    }

    public void onStart() {
        super.onStart();
        Log.v("MyFragment", "onStart");

    }

    public void onPause() {
        super.onPause();
        Log.v("MyFragment", "onPause");

    }

    public void onResume() {
        super.onResume();
        Log.v("MyFragment", "onResume");

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v("MyFragment", "onSaveInstanceState outState");

    }

    public void onStop() {
        super.onStop();
        Log.v("MyFragment", "onStop");

    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.v("MyFragment", "onDestroyView Call");

    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("MyFragment", "onDestroy Call");

    }

    public void onDetach() {
        super.onDetach();
        Log.v("MyFragment", "onDetach Call");

    }

}
