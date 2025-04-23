package com.job.inheri;

public class Derived extends Base{
    public final int amount = 20;

    @Override
    public String display() {
        return "Derived";
    }

    public String printDetails(){
        return  "printDetails";
    }
}
