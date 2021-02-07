package com.example.m3_dayanand_chauhan;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Digitalrecipt extends Fragment {


    public Digitalrecipt() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_digitalrecipt, container, false);
      Button  skips=view.findViewById(R.id.btndigitalskip);
         skips.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Wallet wallet = new Wallet();
                 FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                 fragmentTransaction.replace(R.id.mainlayout, wallet);
                 fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit();

             }
         });
         return view;
    }

}
