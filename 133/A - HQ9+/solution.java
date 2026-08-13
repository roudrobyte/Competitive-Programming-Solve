import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext()){
            return;
        }
        String str = sc.next();
        boolean isAv = true;
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
 
            if(ch=='H' || ch=='Q' || ch=='9'){
                isAv = true;
                break;
            }
            else{
                isAv = false;
            }
        }
        if(isAv){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}