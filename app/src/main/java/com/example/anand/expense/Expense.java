package com.example.anand.expense;

public class Expense {
    public String id;
    public String tag;
    public String desc;
    public String amt;
    public Expense(){
        super();
    }

    public Expense(String id, String tag, String desc, String amt) {
        super();
        this.id = id;
        this.tag = tag;
        this.desc = desc;
        this.amt = amt;
    }
}
