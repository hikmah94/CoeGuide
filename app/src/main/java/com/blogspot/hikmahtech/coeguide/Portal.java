package com.blogspot.hikmahtech.coeguide;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Portal extends Fragment {
    private View rootView;
    public Portal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       rootView= inflater.inflate(R.layout.fragment_portal, container, false);
        CardView portal = (CardView) rootView.findViewById(R.id.groups);
        portal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpeninCustomTab("https://www.coe-minna.com");
                //String url="http://groups.google.com/d/forum/gdg-minna";
                //Intent i= new Intent(Intent.ACTION_VIEW);
                //i.setData(Uri.parse(url));
                //startActivity(i);
            }
        });

        return rootView;
    }

public void OpeninCustomTab(String url){
        Uri website;
        if(!url.contains("https://") && !url.contains("http://")){
        website = Uri.parse("http://"+url);
        }else{
        website = Uri.parse(url);
        }

        CustomTabsIntent.Builder customtabIntent = new CustomTabsIntent.Builder();
        customtabIntent.setToolbarColor(ContextCompat.getColor(getActivity(),R.color.colorPrimary));
        customtabIntent.setShowTitle(true);
        customtabIntent.addDefaultShareMenuItem();
        customtabIntent.setStartAnimations(getActivity(),R.anim.right_in, R.anim.left_out);
        customtabIntent.setExitAnimations(getActivity(),R.anim.left_in,R.anim.right_out);
        Intent copyIntent = new Intent(getActivity(),CopyURLBroadcast.class);
        PendingIntent copypendingIntent = PendingIntent.getBroadcast(getActivity(),0, copyIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        customtabIntent.addMenuItem("Copy Link",copypendingIntent);

        if(chromeInstalled()){
        customtabIntent.build().intent.setPackage("com.android.chrome");
        }
        customtabIntent.build().launchUrl(getActivity(),website);
        }
private boolean chromeInstalled(){
        try{
        getActivity().getPackageManager().getPackageInfo("com.android.chrome",0);
        return true;
        }catch (Exception e){
        return false;

        }
        }

    }

