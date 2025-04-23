package com.job.ref;

public class RefClassTest {
    public static void main(String[] args) {
        RefClass ref = new RefClass();
        ref.value = 10;
        ref.incrementValue(ref);
        System.out.println(ref.value);//
    }

//    public static void main(String[] args) {
//        System.out.println("A");
//        try{
//            throw new IllegalStateException("DATA");
//        }catch (RuntimeException ex){
//            System.out.println("B");
//        } finally {
//            System.out.println("C");
//        }
//        System.out.println("E");
//    }


}
