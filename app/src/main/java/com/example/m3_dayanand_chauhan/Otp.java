package com.example.m3_dayanand_chauhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

public class Otp extends AppCompatActivity {
TextView sendotp,otperror;
    private OtpTextView otpTextView;
    Button otp_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);


        sendotp=findViewById(R.id.tvresendotp);
        otpTextView=findViewById(R.id.otp_view);
        otperror=findViewById(R.id.otperror);
        otp_ok=findViewById(R.id.btn_otp_ok);
        otp_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otpTextView.getOTP().length()<4){
                    otperror.setVisibility(View.VISIBLE);
                    otperror.setText("*Please enter otp.");
                }else {
                    Intent intent=new Intent(Otp.this,log_in.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {
                String otp=otpTextView.getOTP().toString().trim();
                if (otp.length()>4){
                    otperror.setVisibility(View.VISIBLE);
                    otperror.setText("*Please enter otp.");

                }else {
                    otperror.setVisibility(View.INVISIBLE);
                    otperror.setText("");

                }
            }

            @Override
            public void onOTPComplete(String otp) {

            }
        });

        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpTextView.setOTP("");

            }
        });

    }

//    public boolean otperror(){

  //  }
}
