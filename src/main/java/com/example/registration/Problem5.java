package com.example.registration;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem5 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the string: ");
            String str = sc.nextLine();
            if(str.isEmpty())
            {
                System.exit(0);
            }
            StringBuilder sb = new StringBuilder();
            str = str.replaceAll("\\.","");
            String[] words = str.split(" ");
            for (int i=words.length-1;i>=0;i--){
                String output = Arrays.asList(words[i].split(""))
                        .stream()
                        .distinct()
                        .collect(Collectors.joining());
                if(i==0){
                    sb.append(output+".");
                }
                else {
                    sb.append(output+" ");
                }
            }
            System.out.println(sb);
        }

    }
}
