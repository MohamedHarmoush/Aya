package com.fcis.gp.aya.aya;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

/**
 * Created by mohse on 2/14/2018.
 */

public class search extends Fragment {
    private final String TAG = "search";
    private FloatingActionButton RecordBtn;
    public View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_fragment,container,false);
        RecordBtn = view.findViewById(R.id.recordBtn);
        RecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulse();
            }
        });
        return view;
    }
    private void pulse(){

        TextView textView = view.findViewById(R.id.tv_search);
        textView.setText("يستمع...");
        PulsatorLayout pulsator =(PulsatorLayout)view.findViewById(R.id.pulsator);
        pulsator.start();
        Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();

    }
}

