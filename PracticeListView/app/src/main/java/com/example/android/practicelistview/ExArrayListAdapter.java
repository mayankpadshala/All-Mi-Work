package com.example.android.practicelistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by mind on 13/12/16.
 */
public class ExArrayListAdapter extends ArrayAdapter<ExArrayList> {

    //Call the Cunstructor for the Super Class
    public ExArrayListAdapter(Activity context, ArrayList<ExArrayList> exArrayLists) {
        //Above we initialize the internal storage for the context and the list
        //As we have to display more than one text views so we are not using the second argument of the super class ArrayAdapter
        //So it can be assigned any value, Here we are giving it value zero

        super(context, 0, exArrayLists);
    }

    /**
     * Provide a view for the AdapterView (ListView, GridView etc)
     *
     *
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //First of all check if the existing view is being reused, if not inflate the view to create a new one(convertView)
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.layout, parent, false);
        }

        //Get the position of the @exArrayLists object in the list
        ExArrayList currentExArrayList = getItem(position);

        //Find the TextView in the layout.xml file with the id tvdemo1
        TextView demo1TextView = (TextView) listItemView.findViewById(R.id.tvDemo1);
        //Get the demo 1 text from the current object of type ExArrayList
        //Then set this text on the demo1TextView
        demo1TextView.setText(currentExArrayList.getDemo1());

        /**
         * Repeat the process for the other two i.e for demo2 and image icon
         */

        //Find the TextView for Demo 2 with id tvDemo2 from the current created object
        TextView demo2TextView = (TextView) listItemView.findViewById(R.id.tvDemo2);
        //Get the Demo 2 text from the  created object
        //Set the fetched text to the demo2TextView
        demo2TextView.setText(currentExArrayList.getDemo2());

        //Find the ImageView in the layout.xml file with id ivIcon and create an object iconImageView from it
        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.ivIcon);
        //Get the Image resource Id from the Object and then set it to the iconImageView
        iconImageView.setImageResource(currentExArrayList.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
