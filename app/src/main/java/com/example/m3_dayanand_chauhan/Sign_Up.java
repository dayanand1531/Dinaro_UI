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

public class Sign_Up extends AppCompatActivity {
    TextView errorfirstname, errorlastname, errormiddlename, erroremail, errormobileno, errorpassword;
    EditText firstname, lastname, middlename, emailid, mobileno, password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);


        errorfirstname = findViewById(R.id.errorfirst_name);
        errorlastname = findViewById(R.id.errorlast_name);
        errormiddlename = findViewById(R.id.errormiddle_name);
        erroremail = findViewById(R.id.erroremail);
        errormobileno = findViewById(R.id.errormobile_no);
        errorpassword = findViewById(R.id.errorpassword);
        firstname = findViewById(R.id.etfirst_name);
        lastname = findViewById(R.id.etlast_name);
        middlename = findViewById(R.id.etmiddle_name);
        emailid = findViewById(R.id.etemail);
        mobileno = findViewById(R.id.etmobileno);
        password = findViewById(R.id.etpassword);
        signup = findViewById(R.id.btn_signup);

        TextView signtext = findViewById(R.id.tv_signup_color);
        TextView condtxt = findViewById(R.id.tv_signup_condion_color);
        String signtxt = "Easy sign up!";
        String conditiontxt = "By submitting this form, you accept Dinaro’s Terms and Conditions and Privacy Policy.";
        SpannableString spannableString = new SpannableString(signtxt);
        SpannableString spannableString1 = new SpannableString(conditiontxt);
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(getApplicationContext(),"Terms and Conditions",Toast.LENGTH_LONG).show();

            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#ec3b83"));
                ds.setUnderlineText(false);
            }
        };
        ClickableSpan clickableSpan1=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(getApplicationContext(),"Privacy Policy.",Toast.LENGTH_LONG).show();

            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#ec3b83"));
                ds.setUnderlineText(false);

            }
        };
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#ec3b83"));
        ForegroundColorSpan foregroundColorSpan1 = new ForegroundColorSpan(Color.parseColor("#ec3b83"));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Color.parseColor("#ec3b83"));
        spannableString.setSpan(foregroundColorSpan, 12, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(clickableSpan, 45, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(clickableSpan1, 70, 85, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signtext.setText(spannableString);
        condtxt.setText(spannableString1);
        signtext.setMovementMethod(LinkMovementMethod.getInstance());
        condtxt.setMovementMethod(LinkMovementMethod.getInstance());
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!firstnameerror() |!
                        emailerror() | !passworderror() | !mobilenoerror()) {
                    return;
                } else {
                    Intent intent = new Intent(Sign_Up.this, log_in.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                firstnameerror();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        middlename.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //middlenameerror();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // lastnameerror();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mobileno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mobilenoerror();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        emailid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailerror();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passworderror();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public boolean firstnameerror() {
        if (firstname.getText().toString().isEmpty()) {
            errorfirstname.setVisibility(View.VISIBLE);
            errorfirstname.setText("*Please enter first name.");
            return false;
        } else if (!firstname.getText().toString().matches("^[A-Z]+[a-z]*$")) {
            errorfirstname.setVisibility(View.VISIBLE);
            errorfirstname.setText("*Please enter first name.");
            return false;

        } else {
            errorfirstname.setVisibility(View.INVISIBLE);
            errorfirstname.setText("");

            return true;
        }

    }
/*
    public boolean middlenameerror() {
        if (middlename.getText().toString().isEmpty()) {
            errormiddlename.setVisibility(View.VISIBLE);
            errormiddlename.setText("*Please enter middle name.");
            return false;
        } else if (!middlename.getText().toString().matches("^[A-Z]+[a-z]*$")) {
            errormiddlename.setVisibility(View.VISIBLE);
            errormiddlename.setText("*Please enter middle name.");
            return false;

        } else {
            errormiddlename.setVisibility(View.INVISIBLE);
            errormiddlename.setText("");

            return true;
        }

    }

    public boolean lastnameerror() {
        if (lastname.getText().toString().isEmpty()) {
            errorlastname.setVisibility(View.VISIBLE);
            errorlastname.setText("*Please enter last name.");
            return false;
        } else if (!lastname.getText().toString().matches("^[A-Z]+[a-z]*$")) {
            errorlastname.setVisibility(View.VISIBLE);
            errorlastname.setText("*Please enter last name.");
            return false;

        } else {
            errorlastname.setVisibility(View.INVISIBLE);
            errorlastname.setText("");

            return true;
        }

    }

 */

    public boolean mobilenoerror() {
        String number = mobileno.getText().toString().trim();
        if (mobileno.getText().toString().isEmpty()) {
            errormobileno.setVisibility(View.VISIBLE);
            errormobileno.setText("*Please enter mobile no.");
            return false;
        } else if (!number.matches("^[0]*[123456789]\\d{7,12}$")) {
            errormobileno.setVisibility(View.VISIBLE);
            errormobileno.setText("*Please enter mobile no.");
            return false;
        } else {
            errormobileno.setVisibility(View.INVISIBLE);
            errormobileno.setText("");

            return true;
        }

    }

    public boolean emailerror() {
        String useremail = emailid.getText().toString();
        if (emailid.getText().toString().isEmpty()) {
            erroremail.setVisibility(View.VISIBLE);
            erroremail.setText("*Please enter email.");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()) {
            erroremail.setVisibility(View.VISIBLE);
            erroremail.setText("*Please enter email.");
            return false;
        } else {
            erroremail.setVisibility(View.INVISIBLE);
            erroremail.setText("");

            return true;

        }
    }

    public boolean passworderror() {
        String signpassword=password.getText().toString().trim();
        if (password.getText().toString().isEmpty()) {
            errorpassword.setVisibility(View.VISIBLE);
            errorpassword.setText("*Please enter password.");
            return false;

        }else if (signpassword.length()<8){
            errorpassword.setVisibility(View.VISIBLE);
            errorpassword.setText("*Please enter password.");
            return false;


        }


        else {
            errorpassword.setVisibility(View.INVISIBLE);
            errorpassword.setText("");
            return true;


        }
    }

}
