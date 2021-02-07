package com.example.m3_dayanand_chauhan;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Recent extends Fragment {
    TextView recenttime;
Integer[] img={R.drawable.path_path_path,R.drawable.path_path_path,R.drawable.path_path_path,R.drawable.path_path_path,R.drawable.path_path_path,
        R.drawable.path_path_path,R.drawable.path_path_path,R.drawable.path_path_path};
String[] zukuken={"Zuku Kenya","Zuku Kenya","Zuku Kenya","Zuku Kenya","Zuku Kenya","Zuku Kenya","Zuku Kenya","Zuku Kenya"};
String [] payment={"Payment","Payment","Payment","Payment","Payment","Payment","Payment","Payment"};
String [] kes={"- KES 2,499","- KES 2,499","- KES 2,499","- KES 2,499","- KES 2,499","- KES 2,499","- KES 2,499","- KES 2,499"};
String[] viewreceipt={"View receipt","View receipt","View receipt","View receipt","View receipt","View receipt","View receipt","View receipt"};

    public Recent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_recent, container, false);
        ListView listView=view.findViewById(R.id.listview);
        TextView textView=view.findViewById(R.id.tvrecentactivity);
        final ImageView calanderview=view.findViewById(R.id.ivcalander);
        String s="Recent Acitvity.";
        SpannableString spannableString=new SpannableString(s);
        ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(Color.parseColor("#ec3b83"));
        spannableString.setSpan(foregroundColorSpan,15,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        LinearLayout linearLayout = null;

        calanderview.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                datepicker();
            }
        });


        Mylistadpter mylistadpter=new Mylistadpter(getActivity(),img,zukuken,payment,kes,viewreceipt);
        listView.setAdapter(mylistadpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Selected : "+zukuken[position],Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void datepicker(){
        Calendar calendar= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            calendar = Calendar.getInstance();
        }
        int month= 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            month = calendar.get(Calendar.MONTH);
        }
        int day= 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            day = calendar.get(Calendar.DAY_OF_MONTH);
        }
        int year= 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            year = calendar.get(Calendar.YEAR);
        }

        DatePickerDialog datePickerDialog =new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
             //  recenttime.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },year,month,day);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            calendar.set(2010,1,31);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        }
        datePickerDialog.show();


    }

}
