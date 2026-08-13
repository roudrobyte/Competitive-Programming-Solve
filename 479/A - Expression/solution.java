import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
 
        int pos1 = a+b*c;
        int pos2 = a*(b+c);
        int pos3 = (a+b)*c;
        int pos4 = a*b*c;
        int pos5 = a+b+c;
 
        int ans = Math.max(pos1, pos2);
        ans = Math.max(ans, pos3);
        ans = Math.max(ans, pos4);
        ans = Math.max(ans, pos5);
 
        System.out.println(ans);
    }
}