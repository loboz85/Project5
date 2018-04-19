package com.example.android.project5;

/**
 * Created by loboz on 05.03.2018.
 */
/**
 * {@link Place} represents a places that user should visit
 * * It contains a place name, description, image map navigation.
 */
public class Place {
    /** Place description */
    private String mDescription;

    /** Place name */
    private String mPlaceName;

    /** Image resource ID for place */
    private int mImageResourceId;

    //Location
    private String mMapLocation;


    public Place(String placeDescription, String placeName, int imageResourceId, String mapLocation) {
        mDescription = placeDescription;
        mPlaceName = placeName;
        mImageResourceId= imageResourceId;
        mMapLocation= mapLocation;
    }
    /**
     * Get the place description.
     */
    public String getPlaceDescription() {
        return mDescription;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getPlaceName() {
        return mPlaceName;
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
