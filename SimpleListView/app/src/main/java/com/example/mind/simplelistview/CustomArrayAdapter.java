package com.example.mind.simplelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mind on 16/12/16.
 */

public class CustomArrayAdapter extends ArrayAdapter<CustomDataType> {

    CustomDataType currentItem;

    static class ViewHolder{
        TextView textHeading;
        TextView textDescription;
        ImageView image;
    }


    public CustomArrayAdapter(Context context, ArrayList<CustomDataType> dataTypes) {
        super(context, 0 , dataTypes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;


        // Custom Array Adapter Using the Correct Way
//        if (listItemView == null) {
//            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.single_view, parent, false);
//        }
//
//        currentItem = getItem(position);
//
//        TextView heading = (TextView) listItemView.findViewById(R.id.tvHeading);
//        heading.setText(currentItem.getHeading());
//
//        TextView description = (TextView) listItemView.findViewById(R.id.tvDescription);
//        description.setText(currentItem.getDescription());
//
//        ImageView image = (ImageView) listItemView.findViewById(R.id.ivImage);
//        image.setImageResource(currentItem.getImageResourceID());


        //Custom Array Adapter Using ViewHolder
        ViewHolder holder;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.single_view, parent, false);
            holder = new ViewHolder();

            //Created a Data type that stores all the information that our Custom Array Adapter Needs to store and we use it
            //as a tag and set it to created listView to use it when needed
            //So no need to relate to each view every time, We just get a View to fill with all the attributes already defined
            //as a tag to the listview just we have to set the corresponding value
            holder.textHeading = (TextView)listItemView.findViewById(R.id.tvHeading);
            holder.textDescription = (TextView)listItemView.findViewById(R.id.tvDescription);
            holder.image = (ImageView)listItemView.findViewById(R.id.ivImage);

            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        currentItem = getItem(position);

        holder.textHeading.setText(currentItem.getHeading());
        holder.textDescription.setText(currentItem.getDescription());
        holder.image.setImageResource(currentItem.getImageResourceID());

       return listItemView;

    }
}
