package com.example.anand.expense;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    private Button register;
    private EditText username;
    //private EditText email;
    // private EditText mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
        username = (EditText)findViewById(R.id.username);
        //email = (EditText)findViewById(R.id.email);
        //  mobileNumber = (EditText)findViewById(R.id.mobileNumber);
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    username.setTextColor(Color.BLUE);
                    String u = username.getText().toString();
                    if (u.equals("")) {
                        username.setHint("Username is compulsory.");
                        username.setBackgroundColor(Color.GREEN);
                        username.setHintTextColor(Color.WHITE);
                    }
                }
            }
        });

    }
}
