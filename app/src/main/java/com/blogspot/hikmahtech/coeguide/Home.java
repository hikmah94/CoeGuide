package com.blogspot.hikmahtech.coeguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    View rootView;
    public static GridView gridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, null);
        final ArrayList<Word> words = new ArrayList<Word>();
        //words.add("one");
        words.add(new Word("ADMINISTRATION", R.drawable.coe_admin));
        words.add(new Word("ACADEMICS", R.drawable.coe_courses));
        words.add(new Word("EXAMINATIONS", R.drawable.coe_exams));
        words.add(new Word("CGPA CALCULATOR", R.drawable.coe_cgpa));
        words.add(new Word("BOSST CGPA", R.drawable.coe_boostcg));
        words.add(new Word("CODE OF CONDUCT", R.drawable.coe_coc));
        words.add(new Word("Utilities", R.drawable.coe_home));
        words.add(new Word("STUDENT UNION", R.drawable.coe_union));
        WordAdapter adapter = new WordAdapter(getActivity(), words);


        GridView listView = (GridView) rootView.findViewById(R.id.gridview);

        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);
                {
                    if (position == 0) {
                        Intent i = new Intent(getActivity(), Administration.class);
                        startActivity(i);
                    } else if (position == 1) {
                        Intent i = new Intent(getActivity(), Academics.class);
                        startActivity(i);
                    } else if (position == 2) {
                        Intent i = new Intent(getActivity(), Examination.class);
                        startActivity(i);
                    } else if (position == 3) {
                        Intent i = new Intent(getActivity(), Calculator.class);
                        startActivity(i);
                    } else if (position == 4) {
                        Intent i = new Intent(getActivity(), Boost.class);
                        startActivity(i);
                    } else if (position == 5) {
                        Intent i = new Intent(getActivity(), Code.class);
                        startActivity(i);
                    } else if (position == 6) {
                        Intent i = new Intent(getActivity(), Utility.class);
                        startActivity(i);
                    } else if (position == 7) {
                        Intent i = new Intent(getActivity(), Union.class);
                        startActivity(i);
                    }
                }
            }

        });

        return rootView;
    }
}
