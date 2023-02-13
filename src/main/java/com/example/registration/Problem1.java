package com.example.registration;

import java.util.*;

public class Problem1 {
    public static List<String> allPalindromeSubstring(String s)
    {
        List<String> list = new ArrayList<String>();
        for (float pivot = 0; pivot < s.length(); pivot += .5) {
            float palindromeRadius = pivot - (int)pivot;
            while ((pivot + palindromeRadius) < s.length()
                    && (pivot - palindromeRadius) >= 0
                    && s.charAt((int)(pivot - palindromeRadius))
                    == s.charAt((int)(pivot + palindromeRadius))) {

                list.add(s.substring((int)(pivot - palindromeRadius),
                        (int)(pivot + palindromeRadius + 1)));
                palindromeRadius++;
            }
        }
        return list;
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
            List<String> list = allPalindromeSubstring(input);
            System.out.println(list.size());
        }
    }
}
