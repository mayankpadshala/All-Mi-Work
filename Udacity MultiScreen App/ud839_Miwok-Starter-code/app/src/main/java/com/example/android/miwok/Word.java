package com.example.android.miwok;

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

    /**
     *Create a new Word object
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     * @param miwokTranslation is the miwok translation of the word
     */

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
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

}
