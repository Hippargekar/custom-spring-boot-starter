package com.job.str;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StrTest {

    public static void mainV1(String[] args) {
        String java = "may name is pritam";
        java.chars().mapToObj(d-> (char) d)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(entry-> System.out.println(entry.getKey() +" " +entry.getValue()));
    }

    public static void mainV5(String[] args) {
        String value = "123";
        int sum = 0;
        for(int index = 0; index < value.length(); index++){
            int digit = value.charAt(index) - '0';
            sum = sum + digit;
        }
        System.out.println(sum);
    }

    public static void mainV7(String[] args) {
        int number = 22;
        int index = 2;
        boolean isPrime = true;
        while(index < number/2){
            if(number % index == 0){
                isPrime = false;
                break;
            }
            index++;
        }
        System.out.println(isPrime);
    }

    public static void mainV8(String[] args) {
        String value = "987654321-P";
        System.out.println("reverse: " + reverse(value, value.length()-1));
    }

    public static String reverse(String value, int temp) {
        if(temp == 0)return String.valueOf(value.charAt(temp));
        return value.charAt(temp) + reverse(value , temp-1);
    }

    public static void mainV9(String[] args) {
        List<Integer> identifiers =  new ArrayList<>();
        for(int index =57 ; index <= 103; index++){
            identifiers.add(index);
        }
        int partitionSize = 10;
        Collection<List<Integer>> partitionedList = IntStream.range(0, identifiers.size())
                .boxed()
                .collect(Collectors.groupingBy(partition -> (partition / partitionSize),
                        Collectors.mapping(identifiers::get, Collectors.toList())))
                .values();
        for (List<Integer> subList : partitionedList) {
            System.out.println(subList);
        }
    }

    public static void main(String[] args) {
        String value1 = "ABCxyz";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value1.length(); i++) {
            if(value1.charAt(i) >= 'A' && value1.charAt(i) <= 'Z'){
                builder.append((char)(value1.charAt(i) + 32));
            } else if(value1.charAt(i) >= 'a' && value1.charAt(i) <= 'z'){
                builder.append((char)(value1.charAt(i) - 32));
            }
        }
        System.out.println(builder);
    }

    public static void mainV4(String[] args) {
        String java = "miayp naiipme ips pritam";
        Integer[] buffer = new Integer[256];
        Arrays.fill(buffer, 0);
        char[] array = java.toCharArray();
        for(char ch: array){
            buffer[ch] = buffer[ch] + 1;
        }
        int max = buffer[0];
        int idx = 0;
        for(int index=0; index < buffer.length ; index++){
            if(buffer[index]> max){
                max = buffer[index];
                idx = index;
            }
        }
        System.out.println(max+" "+ (char) idx);
//        System.out.println(Arrays.toString(buffer));
    }

    public static void mainV3(String[] args) {
        String value = "abc,pqr,xyz,npm";
        String [] data = value.split(",");
        //System.out.println(Arrays.toString(data));

        int first = 0;
        String buffer = "";
        boolean flag=true;
        for(int index=0; index< value.length(); index ++){
            if(value.charAt(index) == ','){
                if(flag){
                    buffer = value.substring(first, index);
                    flag = false;
                }else{
                    buffer = buffer +" "+ value.substring(first, index);
                }
                first = index+1;
            }
        }
        buffer = buffer +" "+ value.substring(first, value.length());
        System.out.println(buffer);
    }
}
