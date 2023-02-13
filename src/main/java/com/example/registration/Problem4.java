package com.example.registration;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    static String stringSort(String str){
        str = str.replaceAll("[^a-zA-Z0-9]","");
        int begin = str.length() / 2 - 5/2;
        String sub = str.substring(begin,begin+5);
        char[] ar = sub.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }
    public static void main(String[] args) {
        while (true){
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter the string: ");
            String str = sc.nextLine();
            if(str.isEmpty())
            {
                System.exit(0);
            }
            if(str.length()<10){
                System.out.println("The input need to be at least ten characters!!!");
                continue;
            }
            System.out.println(stringSort(str));
        }
    }
}
