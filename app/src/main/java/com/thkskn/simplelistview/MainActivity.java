package com.thkskn.simplelistview;

import android.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.ads.*;


public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign listview
        listView = (ListView)findViewById(R.id.listView);

        //array
        String[] dizi = {"Bintuğ","Taha","Keskin","Computer","Engineer"};

        //ListAdapter
        ListAdapter listAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,dizi);

        //set listadapter
        listView.setAdapter(listAdapter);

        //adapterView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String select = String.valueOf(parent.getItemAtPosition(position));

                Toast.makeText(MainActivity.this,String.valueOf(position+1)+"."+select,Toast.LENGTH_SHORT).show();
            }
        });

        // Java code required.
        // testDevices and loadAdOnCreate attributes are
        // no longer available.
        AdView adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("TEST_DEVICE_ID")
                .build();
        adView.loadAd(adRequest);
    }
}