import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
 
        String str = sc.nextLine();
 
        str = str.toLowerCase();
        String target = "hello";
        int targetCount = 0;
 
        for(int i=0; i<str.length();i++){
            if(str.charAt(i) == target.charAt(targetCount)){
                targetCount++;
            }
            if(targetCount==5){
                break;
            }
        }
        if(targetCount==5){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}