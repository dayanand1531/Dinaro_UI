package com.example.m3_dayanand_chauhan;


import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Billpay_fragment extends Fragment {
Integer[] img={R.drawable.bamba,R.drawable.dstv,R.drawable.faiba,R.drawable.gotv,R.drawable.kenya_power,R.drawable.nairobi_water};
String[] no={"3","10","4","23","5","14"};
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;

    public Billpay_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_billpay_fragment, container, false);
        GridView gridView=view.findViewById(R.id.grid_view);
        Grid_view_adpter grid_view_adpter=new Grid_view_adpter(getActivity(),img,no);
        gridView.setAdapter(grid_view_adpter);
        TextView textView=view.findViewById(R.id.tvrecentactivity);
        String s="Pay a bill";
        SpannableString spannableString=new SpannableString(s);
        ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(Color.parseColor("#ec3b83"));
         spannableString.setSpan(foregroundColorSpan,6,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
         textView.setText(spannableString);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"Selected : "+no[position],Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search,menu);
        MenuItem menuItem=menu.findItem(R.id.app_bar_search);
        SearchManager searchManager= (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        if (menuItem!=null){
            searchView= (SearchView) menuItem.getActionView();

        }
        if (searchView!=null){
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            queryTextListener=new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_search:
                // Not implemented here
                return false;
            default:
                break;
        }
        searchView.setOnQueryTextListener(queryTextListener);
        return super.onOptionsItemSelected(item);

    }


}
