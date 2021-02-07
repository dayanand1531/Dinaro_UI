package com.example.m3_dayanand_chauhan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class Viewpager_adpter extends FragmentStatePagerAdapter {


    public Viewpager_adpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Payment();
            case 1:
                return new Digitalrecipt();
            case 2:
                return new Wallet();
                default:
                    return new Payment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
