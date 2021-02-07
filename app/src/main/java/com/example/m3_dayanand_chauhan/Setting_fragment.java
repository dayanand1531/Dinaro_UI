package com.example.m3_dayanand_chauhan;


import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Setting_fragment extends Fragment {
    Integer[] icon={R.drawable.profile,R.drawable.card_detail,R.drawable.security,R.drawable.alert,R.drawable.help_support,R.drawable.faq,R.drawable.legal,R.drawable.logout};
    String[] title={"Profile","Card details","Security","Notifications","Help & Support","FAQ"
    ,"Legal","Log out"};


    public Setting_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_setting_fragment, container, false);
        ListView listView=view.findViewById(R.id.lvsettings);
        TextView settingdot=view.findViewById(R.id.tv_setting_color_text);
        String setting="Settings.";
        SpannableString spannableString=new SpannableString(setting);
        ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(Color.parseColor("#ec3b83"));
        spannableString.setSpan(foregroundColorSpan,8,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        settingdot.setText(spannableString);

        Setting_list_Adpter setting_list_adpter=new Setting_list_Adpter(getActivity(),icon,title);
        listView.setAdapter(setting_list_adpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Selected : "+title[position],Toast.LENGTH_LONG).show();
            }
        });


        return view;

    }

}
