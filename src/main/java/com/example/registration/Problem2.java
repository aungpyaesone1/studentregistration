package com.example.registration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    public static int getDeleteCount(String input){
        char[] ch = input.toCharArray();
        ArrayList<Character> newList = new ArrayList<Character>();
        newList.add(ch[0]);
        for(int i=1;i<ch.length;i++){
            if(ch[i-1] != ch[i]) {
                newList.add(ch[i]);
            }
        }
        return ch.length-newList.size();
    }

    public static void main(String[] args) {
        while (true){
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter the string: ");
            String input = sc.nextLine();
            if(input.isEmpty())
            {
                System.exit(0);
            }
            System.out.println(getDeleteCount(input));
        }
    }
}
