package com.blogspot.hikmahtech.coeguide;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.R.id.tabs;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeHolder extends Fragment {

    View rootView;
    public static ViewPager viewPager;
    public static TabLayout tab;
    public static int int_items=4;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home_holder,null);
        // Setting ViewPager for each Tabs
        // Set Tabs inside Toolbar
        tab = (TabLayout) rootView.findViewById(R.id.tabsmin);

        viewPager = (ViewPager) rootView.findViewById(R.id.viewpagermain);


        viewPager.setAdapter(new myAdapter(getChildFragmentManager()));
        tab.post(new Runnable() {
            @Override
            public void run() {
                tab.setupWithViewPager(viewPager);
            }
        });
        return rootView;
    }
    class myAdapter extends FragmentPagerAdapter {
        public myAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int positon){
            switch (positon){
                case 0:return new Info ();
                case 1: return new Home ();
                case 2: return new Portal();
                case 3: return new Forum();
            }
            return null;
        }
        @Override
        public int getCount(){
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0: return "Info";
                case 1: return "Home";
                case 2: return "Portal";
                case 3: return "Forum";
            }
            return null;
        }
    }
}
