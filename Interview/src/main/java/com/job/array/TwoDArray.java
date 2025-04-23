package com.job.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TwoDArray {

    public static void mainV10(String[] args) {
        Integer[] array = new Integer[]{10,0,4,0,5,9,0,7,0,55};
        Arrays.sort(array, Collections.reverseOrder());
        //Arrays.fill(array, 1);
       System.out.println(Arrays.toString(array));

       int max = Math.max(10,20);
       System.out.println(max);
       // moveZeroLast(new int[]{10,0,4,0,5,9,0,7,0,55});
    }

    public static void mainV11(String[] args) {
        int[] array = new int[]{10,55,87,44,12,99,86};
        int first =0;
        int second = 0;
        for(int arr:  array){
            if(arr> first){
                second = first;
                first = arr;
            } else if (arr> second && arr!=first) {
                second = arr;
            }
        }
        System.out.println(first +" "+second);
    }

    public static void main(String[] args) {
        int num = 1793;

        int digit = num % 1000;
        System.out.println("digit:"+digit);
        num = num /10;
        System.out.println("num:"+ num);

        digit = num % 100;
        System.out.println("digit:"+digit);
        num = num /10;
        System.out.println("num:"+ num);

        digit = num % 10;
        System.out.println("digit:"+digit);
        num = num /10;
        System.out.println("num:"+ num);
    }

    public static void moveZeroLast(int[] array){
        int pointer = 0;
        for(int index = 0; index < array.length; index++) {
            if (array[index] != 0) {
                int temp = array[pointer];
                array[pointer] = array[index];
                array[index] = temp;
                pointer++;
            }
        }
        printArray(array);
    }

    public static void printArray(int[] array){
        for(int num: array){
            System.out.println(num);
        }
    }

    public static void moveZeroFirst(int[] array){
        int size = array.length -1;
        int pointer = size;
        for(int index = size; index >= 0; --index) {
            if (array[index] != 0) {
                int temp = array[pointer];
                array[pointer] = array[index];
                array[index] = temp;
                pointer--;
            }
        }
        printArray(array);
    }

    public static void printData(){
//        for(char ch ='a'; ch<= 'z' ; ch++){
//            System.out.print(ch);
//        }
//        System.out.println();
        for(char ch ='A'; ch<= 'Z' ; ch++){
            System.out.print(ch);
        }
    }

    public static void mainV1(String[] args) {
        int[][] array = new int[2][2];
        array[0][0] = 1;
        array[0][1] = 2;
        array[1][0] = 3;
        array[1][1] = 4;
//        System.out.println(array.length);
//        for(int rows=0; rows < array.length; rows++){
//            System.out.println("Before:"+ rows);
//            for(int cols=0; cols < array[rows].length; cols++){
//                System.out.println(array[rows][cols]);
//            }
//            System.out.println("After:"+ rows);
//        }

//        int arr[][] = new int[1][1];
//        arr[0][0] = 10;

        int arr1[][] = {
                {1,2},
                {2,3},
                {4,5},
                {6,7}
        };
//        arr1[0][0] = 10;
//        arr1[0][1] = 20;
        displayData(arr1);
    }

    public static void displayData(int[][] array){
        int number = array.length;
        for(int index=0; index< number; index++){
            System.out.println(array[index][0]);
        }
    }

    public static void printArray(int[][] array){
        for(int row=0; row< array.length; row++){
            for(int col=0; col< array[row].length; col++){
                System.out.println(array[row][col]);
            }
        }
    }
}
