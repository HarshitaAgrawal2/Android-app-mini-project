package com.example.anand.expense;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class add_income_form extends AppCompatActivity {
    private Button btn, btnviewAll;
    private EditText amt, desc;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income_form);
        final Spinner c = (Spinner) findViewById(R.id.Income_category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.income_category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setAdapter(adapter);

        btn = (Button) findViewById(R.id.btn_save);
        amt = (EditText) findViewById(R.id.amount);
        desc = (EditText) findViewById(R.id.desc);
        btnviewAll = (Button) findViewById(R.id.temp);
        myDb = new DatabaseHelper(this);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (amt.getText().toString().length() == 0) {
                            Toast.makeText(add_income_form.this, "Enter amount", Toast.LENGTH_LONG).show();
                        } else {
                            String tag = c.getSelectedItem().toString();
                            if (tag.equals("Select income category")) {
                                tag = "-";
                            }
                            boolean isInserted = myDb.insertIncome(amt.getText().toString(),
                                    tag,
                                    desc.getText().toString());
                            if (isInserted == true) {
                                btn.setBackgroundColor(Color.BLACK);
                                btn.setText("Income saved !");
                            } else {
                                Toast.makeText(add_income_form.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllIncome();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
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
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
