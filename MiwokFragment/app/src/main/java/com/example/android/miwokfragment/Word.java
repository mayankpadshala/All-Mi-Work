package com.example.android.miwokfragment;

/**
 * Created by mind on 12/12/16.
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word
 */
public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translations for the word */
    private String mMiwokTranslation;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioId;

    /**
     *Create a new Word object
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     * @param miwokTranslation is the miwok translation of the word
     */

    public Word(String defaultTranslation, String miwokTranslation, int audioId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioId = audioId;

    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioId = audioId;
    }

    /**
     * Get the default translation of the word
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get Miwok translation
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get Image Resource Id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioId() {
        return mAudioId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioId=" + mAudioId +
                '}';
    }
}
