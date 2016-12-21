package com.example.android.forpracticeconcepts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mind on 13/12/16.
 */
public class CustomArrayAdapter extends ArrayAdapter<CustomArrayListType> {

    public CustomArrayAdapter(Activity context, ArrayList<CustomArrayListType> customArrayListTypes) {
        super(context, 0, customArrayListTypes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_view, parent, false);
        }

        CustomArrayListType currentListPosition = getItem(position);

        TextView color = (TextView) listItemView.findViewById(R.id.tvColor);
        color.setText(currentListPosition.getColorName());

        TextView hash = (TextView) listItemView.findViewById(R.id.tvHash);
        hash.setText(currentListPosition.getHashCode());

        ImageView iconColor = (ImageView) listItemView.findViewById(R.id.ivIcon);
        iconColor.setImageResource(currentListPosition.getImageResourceId());

        return listItemView;
    }
}
