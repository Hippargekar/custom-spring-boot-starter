package com.job.inheri.v1;

public class Derived extends Base{

    public Derived(){
        incrementValue();
    }

    public void incrementValue(){
//        System.out.println("Derived before: "+ value);
        value = value + 2;
//        System.out.println("Derived after: "+ value);
    }
}
