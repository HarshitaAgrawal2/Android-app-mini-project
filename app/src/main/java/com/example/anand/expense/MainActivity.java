package com.example.anand.expense;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button add_expense_btn;
    private Button view_expense_btn;
    private Button quotes;
    private Button add_income_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_expense_btn = (Button) findViewById(R.id.add_expense_button);
        add_expense_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addExpenseForm.class);
                startActivity(intent);
            }
        });
        view_expense_btn = (Button) findViewById(R.id.view_expenses_button);
        view_expense_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewExpenses.class);
                startActivity(intent);
            }
        });
        quotes = (Button) findViewById(R.id.quotes);
        quotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Quotes.class);
                startActivity(intent);
            }
        });
        add_income_btn = (Button) findViewById(R.id.add_income_button);
        add_income_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, add_income_form.class);
                startActivity(intent);
            }
        });

        quotes.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                quotes.setBackgroundColor(Color.RED);
                quotes.setTextColor(Color.YELLOW);
                return false;
            }
        });

    }
}
