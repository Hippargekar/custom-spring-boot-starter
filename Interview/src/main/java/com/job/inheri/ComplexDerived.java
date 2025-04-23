package com.job.inheri;

public class ComplexDerived extends Derived{
    public final int amount = 30;

    @Override
    public String display() {
        return "ComplexDerived";
    }

    public static void main(String[] args) {
//        Base base = new ComplexDerived();
//        System.out.println(base.amount);//10
//        System.out.println(base.display());//ComplexDerived

        Base base = new Derived();
        System.out.println(base.amount);//10
        System.out.println(base.display());//Derived
        //System.out.println(base.printDetails());//ERROR.
    }
}
