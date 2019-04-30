package com.example.anand.expense;

public class Expense {
    public String id;
    public String amt;
    public String tag;
    public String desc;

    public Expense() {
        super();
    }

    public Expense(String id, String amt, String tag, String desc) {
        super();
        this.id = id;
        this.amt = amt;
        this.tag = tag;
        this.desc = desc;
    }
}
