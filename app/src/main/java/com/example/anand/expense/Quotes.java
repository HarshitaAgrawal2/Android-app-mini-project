package com.example.anand.expense;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Quotes extends AppCompatActivity {
    ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        i1 = (ImageView) findViewById(R.id.image1);
        i2 = (ImageView) findViewById(R.id.image2);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.image1){
                    i1.setVisibility(v.GONE);
                    i2.setVisibility(v.VISIBLE);
                }
                if(v.getId()==R.id.image2){
                    i1.setVisibility(v.VISIBLE);
                    i2.setVisibility(v.GONE);
                }
            }
        });
    }
}
