package com.job.prio;

public class PrioTest {

    public static void main(String[] args) {
        new PrioTest().display("Object");
        new PrioTest().display(null);
    }

    public void display(String str){
        System.out.println("String");
    }

    public void display(Object obj){
        System.out.println("Object");
    }
}
