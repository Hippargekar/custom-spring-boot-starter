package com.job.inheri.v1;

public class DerivedTest {
    public static void main(String[] args) {
        Base base = new Derived();
        System.out.println(base.value);//9
    }
}
