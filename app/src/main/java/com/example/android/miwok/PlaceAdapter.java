package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.content.ContextCompat;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by loboz on 06.03.2018.
 */

    public class PlaceAdapter extends ArrayAdapter<Place>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    public PlaceAdapter(Context context, ArrayList<Place> places, int colorResourceId)  {
        /**
         * Create a new {@link PlaceAdapter} object.
         *
         * @param context is the current context (i.e. Activity) that the adapter is being created in.
         * @param places is the list of {@link Place}s to be displayed.
         * @param colorResourceId is the resource ID for the background color for this list of places
         */


        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentPlace.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentPlace.getPlaceDescription());

        // Find the TextView in the list_item.xml layout with the ID version_number
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        imageView.setImageResource(currentPlace.getImageResourceId());


        //check if there is image associated
        if (imageView.getDrawable() == null) {
            // If an image is not available, set visibility to gone
            imageView.setVisibility(View.GONE);
        } else {
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }
}
