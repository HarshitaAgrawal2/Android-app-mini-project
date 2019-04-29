package com.example.anand.expense;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addExpenseForm extends AppCompatActivity {
    private Button calculator;
    private Button btn, btnviewAll;
    private EditText amt, desc;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense_form);
        calculator = (Button) findViewById(R.id.calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addExpenseForm.this, calculator.class);
                startActivity(intent);
            }
        });
        final Spinner spinner = (Spinner) findViewById(R.id.category);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        btn = (Button)findViewById(R.id.btn_save);
        amt = (EditText)findViewById(R.id.amount);
        desc = (EditText)findViewById(R.id.desc);
        btnviewAll = (Button)findViewById(R.id.temp);
        myDb = new DatabaseHelper(this);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String tag = spinner.getSelectedItem().toString();
                        boolean isInserted = myDb.insertData(amt.getText().toString(),
                                tag,
                                desc.getText().toString() );
                        if(isInserted == true){
                            btn .setBackgroundColor(Color.BLACK);
                            btn.setText("Expense saved !");
                            Toast.makeText(addExpenseForm.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(addExpenseForm.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Amount :" + res.getString(1) + "\n");
                            buffer.append("Category :" + res.getString(2) + "\n");
                            buffer.append("Description :" + res.getString(3) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
