import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace("+", "");
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
 
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print("+");
            }
        }
        System.out.println();
    }
}