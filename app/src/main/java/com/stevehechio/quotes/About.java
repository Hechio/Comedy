package com.stevehechio.quotes;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class About extends AppCompatActivity {
    public AdView myAd;
    public AdRequest myRequest;
    private ImageButton myButton;
    ExpandableListView expandableListView;
    HashMap<String, List<String>>myHeader;
    List<String>myChild;
    ExpandAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
         myButton=  (ImageButton)findViewById(R.id.imageButton);
         expandableListView=(ExpandableListView)findViewById(R.id.expand);
         myHeader= ProvideData.getInfo();
         myChild = new ArrayList<String>(myHeader.keySet());
        adapter = new ExpandAdapter(this, myHeader,myChild);
         expandableListView.setAdapter(adapter);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            android.support.v7.widget.Toolbar myToolbar= (Toolbar)findViewById(R.id.toolbar2);
            setSupportActionBar(myToolbar);
            

        }
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About.this,MainActivity.class);
                startActivity(i);
            }
        });
        myAd = (AdView)findViewById(R.id.adViewNext);
       myRequest = new AdRequest.Builder().addTestDevice("A6256E31A1308D7B2A280A457E8B6739").build();
        myAd.loadAd(myRequest);

    }
}

