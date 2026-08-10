import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i=1; i<=a; i++) {
            String str = sc.next();
            int leng = str.length();
 
            if (leng > 10) {
                leng -= 2;
                String str1 = "";
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        str1 += str.charAt(0);
                    } else if (j == 1) {
                        str1 += leng;
                    } else {
                        str1 += str.charAt(str.length() - 1);
                    }
                }
                System.out.println(str1);
            } else {
                System.out.println(str);
            }
        }
    }
}