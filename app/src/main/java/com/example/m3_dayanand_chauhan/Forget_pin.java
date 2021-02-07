package com.example.m3_dayanand_chauhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forget_pin extends AppCompatActivity {
    Button contin;
    EditText forgetpin_mobileno;
    TextView errorfogetpin_mobileno,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pin);
        contin=findViewById(R.id.btn_continue);


        TextView textView=findViewById(R.id.tv_porget_pin);
        forgetpin_mobileno=findViewById(R.id.et_forget_mobileno);
        cancel=findViewById(R.id.tv_forgetpin_cancel);

        errorfogetpin_mobileno=findViewById(R.id.tverror_forgetpin_mobileno);
        String s="Forgot your PIN?";
        SpannableString spannableString=new SpannableString(s);
        ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(Color.parseColor("#ec3b83"));
        spannableString.setSpan(foregroundColorSpan,15,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgetpin_mobileno.setText("");
                Toast.makeText(getApplicationContext(),"Cancel forget pin",Toast.LENGTH_LONG).show();
            }
        });
        contin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (forgetpin_mobileno.getText().toString().isEmpty()){
                    errorfogetpin_mobileno.setVisibility(View.VISIBLE);
                    errorfogetpin_mobileno.setText("*Please enter mobile no.");
                }
                else {
                    Intent intent=new Intent(Forget_pin.this,Otp.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
        forgetpin_mobileno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mobilno=forgetpin_mobileno.getText().toString().trim();
                if (forgetpin_mobileno.getText().toString().isEmpty()){
                    errorfogetpin_mobileno.setVisibility(View.VISIBLE);
                    errorfogetpin_mobileno.setText("*Please enter mobile no.");

                }else if(!forgetpin_mobileno.getText().toString().matches("^[0]*[123456789]\\d{7,12}$")){
                    errorfogetpin_mobileno.setVisibility(View.VISIBLE);
                    errorfogetpin_mobileno.setText("*Please enter mobile no.");
                    //  usernameerrorlogin.setText("*Please enter username.");
                }else {
                    errorfogetpin_mobileno.setVisibility(View.INVISIBLE);
                    errorfogetpin_mobileno.setText("");


                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }


}
