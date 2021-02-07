package com.example.m3_dayanand_chauhan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class log_in extends AppCompatActivity {

Button login;
TextView errorloginemail,errorloginpassword,forgetpassword;
EditText loginemail,loginpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        errorloginemail=findViewById(R.id.errorloginemail);
        errorloginpassword=findViewById(R.id.tverrorloginpassword);
        loginemail=findViewById(R.id.eteamiladdress);
        loginpassword=findViewById(R.id.etloginpassword);
        login=findViewById(R.id.btn_login_dinaro);
        forgetpassword=findViewById(R.id.tvforgetpassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(log_in.this,Main_menu.class);
                startActivity(intent);
                finish();
            }
        });
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(log_in.this,Forget_pin.class);
                startActivity(intent);
                finish();
            }
        });
        TextView dot=findViewById(R.id.tv_login_dot);
        TextView signuptxt=findViewById(R.id.tv_login_signtxt);

        String s="Don’t have an account? Sign up!";
        String s1="Log in to Dinaro.";
        SpannableString spannableString1=new SpannableString(s1);
        SpannableString spannableString=new SpannableString(s);
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent=new Intent(log_in.this,Sign_Up.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#ec3b83"));
                ds.setUnderlineText(false);
            }
        };
        ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(Color.parseColor("#ec3b83"));
        ForegroundColorSpan foregroundColorSpan1=new ForegroundColorSpan(Color.parseColor("#ec3b83"));
        spannableString.setSpan(clickableSpan,23,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(foregroundColorSpan1,16,17,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signuptxt.setText(spannableString);
        dot.setText(spannableString1);
        signuptxt.setMovementMethod(LinkMovementMethod.getInstance());
        login=findViewById(R.id.btn_login_dinaro);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!vadillogin()){
                  //  Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(log_in.this, Main_menu.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
        loginemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usernameid =loginemail.getText().toString().trim();
                if (loginemail.getText().toString().isEmpty()){
                    errorloginemail.setVisibility(View.VISIBLE);
                    errorloginemail.setText("*Please enter email.");

                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(usernameid).matches()){
                    errorloginemail.setVisibility(View.VISIBLE);
                    errorloginemail.setText("*Please enter email.");
                }

                else {
                    errorloginemail.setVisibility(View.INVISIBLE);
                    errorloginemail.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        loginpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String login_password = loginpassword.getText().toString().trim();
                if (loginpassword.getText().toString().isEmpty()) {
                    errorloginpassword.setVisibility(View.VISIBLE);
                    errorloginpassword.setText("*Please enter password.");

                }else if (login_password.length()<8){
                    errorloginpassword.setVisibility(View.VISIBLE);
                    errorloginpassword.setText("*Please enter password.");


                }

                else {
                    errorloginpassword.setVisibility(View.INVISIBLE);
                    errorloginpassword.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
    public  boolean vadillogin(){
        if (loginemail.getText().toString().isEmpty()){
            errorloginemail.setVisibility(View.VISIBLE);
            errorloginemail.setText("*Please enter email.");
            loginemail.requestFocus();
            return true;
        }
        else if (loginpassword.getText().toString().isEmpty()){
            errorloginpassword.setVisibility(View.VISIBLE);
            errorloginpassword.setText("*Please enter password.");
            loginpassword.requestFocus();
            return true;
        }

        return false;

    }


}
