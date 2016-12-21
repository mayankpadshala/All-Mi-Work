package com.example.android.forpracticeconcepts;

/**
 * Created by mind on 13/12/16.
 */
public class CustomArrayListType {

    private String mColorName;

    private String mHashCode;

    private int mImageResourceId;

    public CustomArrayListType(String ColorName, String HashCode, int ImageResourceId) {
        mColorName = ColorName;
        mHashCode = HashCode;
        mImageResourceId = ImageResourceId;
    }


    public String getColorName() {
        return mColorName;
    }

    public String getHashCode() {
        return mHashCode;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

}
