package com.example.m3_dayanand_chauhan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;

public class Welcome extends AppCompatActivity {
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private CircleIndicator dotsLayout;
    private TextView[] dots;
    private int[] layouts={R.layout.fragment_payment,
            R.layout.fragment_digitalrecipt, R.layout.fragment_wallet};
    private Button btnSkip, btn_getstarted;
    private PrefManager prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        // Making notification bar transparent


        setContentView(R.layout.activity_welcome);
        viewPager=findViewById(R.id.viewpager);
        dotsLayout=findViewById(R.id.indicator);
        btnSkip=findViewById(R.id.btn_welcome_skip);
        btn_getstarted=findViewById(R.id.btn_welcome_getstarted);

        addBottomDots(0);
        //changeStatusBarColor();

         myViewPagerAdapter=new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                }else if (btnSkip.getText().toString().equals("Login")){
                    Intent intent=new Intent(getApplicationContext(),log_in.class);
                    startActivity(intent);
                    finish();
                }

                else {
                    launchHomeScreen();
                }



            }
        });

        btn_getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Get started",Toast.LENGTH_LONG).show();
            }


        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //boolean a=(position==layouts.length-1);
                addBottomDots(position);
                if (position == layouts.length - 1) {
                    // last page. make button text to GOT IT
                  //  btnNext.setText(getString(R.string.start));
                    btnSkip.setText("Login");
                    btnSkip.setVisibility(View.VISIBLE);
                    btn_getstarted.setVisibility(View.VISIBLE);
                   // btnSkip.setVisibility(View.VISIBLE);
                   // btnSkip.setText("Login");
                  //  btn_getstarted.setVisibility(View.INVISIBLE);
                   // btn_getstarted.setVisibility(View.INVISIBLE);
                } else {
                   // btnNext.setText(getString(R.string.next));
                    btnSkip.setVisibility(View.VISIBLE);
                    btnSkip.setText("Skip");
                    btn_getstarted.setVisibility(View.INVISIBLE);
                    // still pages are left
                  //  btnNext.setText(getString(R.string.next));

                  //  btnSkip.setVisibility(View.VISIBLE);
                  //  btnSkip.setText("Skip");
                 //   btn_getstarted.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }



    private int getItem(int i) {
        return viewPager.getCurrentItem()+i;

    }

  /*  private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

   */

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }
    

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(Welcome.this, MainActivity.class));
        finish();
    }




public class MyViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;

    public MyViewPagerAdapter() {
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(layouts[position], container, false);
        container.addView(view);

     /*   btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnSkip.getText().toString().equals("Skip")){
                    launchHomeScreen();
                }
                else if (btnSkip.getText().toString().equals("Login")){
                    Intent intent=new Intent(getApplicationContext(),log_in.class);
                    startActivity(intent);

                }

            }
        }); */

        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
}
