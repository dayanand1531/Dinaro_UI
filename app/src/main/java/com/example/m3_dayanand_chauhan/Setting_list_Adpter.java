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

public class Setting_list_Adpter extends ArrayAdapter {
    Activity context;
    Integer[] icon;
    String[] title;
    public Setting_list_Adpter(@NonNull Activity context,Integer[] icon,String[] title) {
        super(context,R.layout.setting_list_item,icon);
        this.context=context;
        this.icon=icon;
        this.title=title;
    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.setting_list_item, null,true);
        ImageView icon1=rowView.findViewById(R.id.iv_setting_list_icon);
        TextView title1 =rowView.findViewById(R.id.tv_setting_title);
       // TextView payment1 =rowView.findViewById(R.id.tvpayment);
      //  TextView kes1 =rowView.findViewById(R.id.tvkes);
       // TextView viewrecipt =rowView.findViewById(R.id.tvviewrecept);
        //  TextView details=rowView.findViewById(R.id.tvdetail2);

        icon1.setImageResource(icon[position]);
        title1.setText(title[position]);
//        payment1.setText(payment[position]);
 //       kes1.setText(kes[position]);
  //      viewrecipt.setText(viewreport[position]);
        // details.setText(detail1[position]);
        return rowView;
    }
}
