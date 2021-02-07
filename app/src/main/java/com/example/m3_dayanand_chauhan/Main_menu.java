package com.example.m3_dayanand_chauhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_menu extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        bottomNavigationView=findViewById(R.id.bottomnivbar);
        frameLayout=findViewById(R.id.framlayout);
        Fragment fragment=new Recent();
        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout,fragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment seletedfragment=null;
                switch (menuItem.getItemId()){
                    case R.id.recent:
                        seletedfragment=new Recent();
                       // Toast.makeText(getApplicationContext(),"Open Home",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.paybill:
                        seletedfragment=new Billpay_fragment();
                       // Toast.makeText(getApplicationContext(),"Open Contact",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.setting:
                        seletedfragment=new Setting_fragment();
                        bottomNavigationView.setVisibility(View.INVISIBLE);
                      //  Toast.makeText(getApplicationContext(),"Open Chat",Toast.LENGTH_LONG).show();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout,seletedfragment).commit();
                return true;
            }

        });
    }
}
