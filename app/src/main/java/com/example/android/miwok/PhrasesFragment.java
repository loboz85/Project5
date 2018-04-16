/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * {@link Fragment} that displays a list of phrases.
 */
public class PhrasesFragment extends Fragment {

    public PhrasesFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create and setup the {@link AudioManager} to request au

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("one", "lutti", R.drawable.number_one, getString(R.string.addressJurkovic)));
        places.add(new Place("two", "otiiko", R.drawable.number_two,getString(R.string.addressJurkovic)));
        places.add(new Place("three", "tolookosu", R.drawable.number_three,getString(R.string.addressJurkovic)));
        places.add(new Place("four", "oyyisa", R.drawable.number_four,getString(R.string.addressJurkovic)));
        places.add(new Place("five", "massokka", R.drawable.number_five,getString(R.string.addressJurkovic)));
        places.add(new Place("six", "temmokka", R.drawable.number_six,getString(R.string.addressJurkovic)));
        places.add(new Place("seven", "kenekaku", R.drawable.number_seven,getString(R.string.addressJurkovic)));
        places.add(new Place("eight", "kawinta", R.drawable.number_eight,getString(R.string.addressJurkovic)));
        places.add(new Place("nine", "wo’e", R.drawable.number_nine,getString(R.string.addressJurkovic)));
        places.add(new Place("ten", "na’aacha", R.drawable.number_ten,getString(R.string.addressJurkovic)));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_listt.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);


        //open maps  with onClickListener


        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                final String goToAddress = getString(R.string.goTo) + places.get(position);
                Intent gps = new Intent(Intent.ACTION_VIEW);
                gps.setData(Uri.parse(goToAddress));
                startActivity(gps);

            }
        });

        return rootView;
    }


}