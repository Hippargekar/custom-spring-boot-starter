package com.job.inheri.v1;

public class Base {
    public int value = 5;

    public Base(){
//        System.out.println(this);
        incrementValue();
    }

    public void incrementValue(){
          value = value + 5;
    }
}
