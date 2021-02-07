package com.example.m3_dayanand_chauhan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class Mylistadpter extends ArrayAdapter {

    Activity context;
    Integer[] img;
    String[] zukuken;
    String[] payment;
   // String[] ken;
    String[] kes;
    String[] viewreport;
    public Mylistadpter(@NonNull Activity context,Integer[] img,String []zukuken,String[] payment,String[] kes,String[]viewreport) {
        super(context,R.layout.listitem,img);
        this.context=context;
        this.img=img;
        this.zukuken=zukuken;
        this.payment=payment;
        this.kes=kes;
        this.viewreport=viewreport;

    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listitem, null,true);
        ImageView zukuimg=rowView.findViewById(R.id.ivzuku);
        TextView zukuken1 =rowView.findViewById(R.id.tvzukuken);
        TextView payment1 =rowView.findViewById(R.id.tvpayment);
        TextView kes1 =rowView.findViewById(R.id.tvkes);
        TextView viewrecipt =rowView.findViewById(R.id.tvviewrecept);
      //  TextView details=rowView.findViewById(R.id.tvdetail2);

        zukuimg.setImageResource(img[position]);
        zukuken1.setText(zukuken[position]);
        payment1.setText(payment[position]);
        kes1.setText(kes[position]);
        viewrecipt.setText(viewreport[position]);

        viewrecipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"View Receipt",Toast.LENGTH_LONG).show();
            }
        });
       // details.setText(detail1[position]);
        return rowView;
    }
}
