package com.example.anand.expense;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class add_income_form extends AppCompatActivity {
    private Button save;
    private EditText desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income_form);
        Spinner c = (Spinner) findViewById(R.id.Income_category);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.income_category_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setAdapter(adapter);

        save = (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save.setBackgroundColor(Color.BLACK);
                save.setText("Income saved !");
            }
        });

        desc = (EditText)findViewById(R.id.desc);
        desc.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==KEYCODE_ENTER){
                    desc.setBackgroundColor(Color.GREEN); // not worked
                }
                return false;
            }
        });
    }
}
