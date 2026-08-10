import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = sc.nextLine();
        boolean isSame = true;
 
        str = str.toLowerCase();
        str1 = str1.toLowerCase();
 
        for(int i=0; i<str.length();i++){
            if(str.charAt(i) != str1.charAt(i)){
                int ascii = (int)str.charAt(i);
                int ascii1 = (int)str1.charAt(i);
 
                if(ascii>ascii1){
                    System.out.println("1");
                    isSame = false;
                    break;
                }
                else{
                    System.out.println("-1");
                    isSame = false;
                    break;
                }
            }
        }
        if(isSame){
            System.out.println("0");
        }
    }
}