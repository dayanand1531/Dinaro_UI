package com.example.m3_dayanand_chauhan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Grid_view_adpter extends ArrayAdapter {
    Activity context;
    Integer[] img;
    String[] no;
    public Grid_view_adpter(@NonNull Activity context,Integer[] img,String[] no) {
        super(context,R.layout.billpay_itemlist,img);
        this.context=context;
        this.img=img;
        this.no=no;
    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.billpay_itemlist, null,true);
        ImageView img1=rowView.findViewById(R.id.im_billpay_img);
        TextView no1 =rowView.findViewById(R.id.textView3);
        // TextView payment1 =rowView.findViewById(R.id.tvpayment);
        //  TextView kes1 =rowView.findViewById(R.id.tvkes);
        // TextView viewrecipt =rowView.findViewById(R.id.tvviewrecept);
        //  TextView details=rowView.findViewById(R.id.tvdetail2);

        img1.setImageResource(img[position]);
        no1.setText(no[position]);
//        payment1.setText(payment[position]);
        //       kes1.setText(kes[position]);
        //      viewrecipt.setText(viewreport[position]);
        // details.setText(detail1[position]);
        return rowView;
    }
}
