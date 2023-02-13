import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
    static String stringSort(String str){
        str = str.replaceAll("[^a-zA-Z0-9]","");
        int begin = str.length() / 2 - 5/2;
        String output = str.substring(begin,begin+5);
        Arrays.sort(output.toCharArray());
        return output;
    }
    public static void main(String[] args) {
        while (true){
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter the string: ");
            String str = sc.nextLine();
            System.out.println(stringSort(str));
        }
    }
}
