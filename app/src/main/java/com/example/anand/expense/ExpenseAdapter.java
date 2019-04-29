package com.example.anand.expense;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    Context context;
    int layoutResourceId;
    Expense data[] = null;

    public ExpenseAdapter(Context context, int layoutResourceId, Expense[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ExpenseHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ExpenseHolder();
            holder.id = (TextView)row.findViewById(R.id.id);
            holder.tag = (TextView)row.findViewById(R.id.tag);
            holder.d = (TextView)row.findViewById(R.id.desc);
            holder.amt = (TextView)row.findViewById(R.id.amt);

            row.setTag(holder);
        }
        else
        {
            holder = (ExpenseHolder)row.getTag();
        }

        Expense exp = data[position];
        holder.id.setText(exp.id);
        holder.tag.setText(exp.tag);
        holder.d.setText(exp.desc);
        holder.amt.setText(exp.amt);

        return row;
    }

    static class ExpenseHolder
    {
        TextView id,tag,d,amt;
    }
}