package com.example.android.miwok;

/**
 * Created by loboz on 05.03.2018.
 */
/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * * It contains a default translation and a Miwok translation for that word.
 */
public class Word {
    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image resource ID for the word */
    private int mImageResourceId;

    //Location coordinates
    private String mMapLocation;


    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, String mapLocation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId= imageResourceId;
        mMapLocation= mapLocation;
    }
    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
        }



    /**
     * Get location
     */
    public String getMapLocation() {
        return mMapLocation;
    }



}
