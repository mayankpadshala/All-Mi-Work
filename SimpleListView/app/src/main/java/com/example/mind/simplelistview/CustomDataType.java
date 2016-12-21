package com.example.mind.simplelistview;

/**
 * Created by mind on 16/12/16.
 */

public class CustomDataType {

    private String mHeading;

    private String mDescription;

    private int mImageResourceID;

    public CustomDataType(String Heading, String Description, int ImageResourceId) {
        mHeading = Heading;
        mDescription = Description;
        mImageResourceID = ImageResourceId;
    }

    public String getHeading() {
        return mHeading;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

}
