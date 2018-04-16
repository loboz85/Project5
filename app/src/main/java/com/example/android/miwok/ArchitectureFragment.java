package com.example.android.miwok;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of architecture places
 */
public class ArchitectureFragment extends Fragment {


    public ArchitectureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create and setup the {@link AudioManager} to request au

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.desEmpire), getString(R.string.nameEmpire),
                R.drawable.empire, getString(R.string.locEmpire)));
        places.add(new Place(getString(R.string.desOculus), getString(R.string.nameOculus),
                R.drawable.oculus, getString(R.string.locOculus)));
        places.add(new Place(getString(R.string.desGTC), getString(R.string.nameGCT),
                R.drawable.grandcentral, getString(R.string.locGTC)));
        places.add(new Place(getString(R.string.desBrooklyn), getString(R.string.nameBrooklyn),
                R.drawable.brooklyn, getString(R.string.locBrooklyn)));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_list.xmll layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);


        //open maps  with onClickListener


        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Place place = places.get(position);
                final String takeMeTo = getString(R.string.goTo) + place.getMapLocation();
                Intent gps = new Intent(Intent.ACTION_VIEW);
                gps.setData(Uri.parse(takeMeTo));
                startActivity(gps);

            }
        });

        return rootView;
    }


}