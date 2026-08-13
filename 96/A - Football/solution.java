import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNext()){
            return;
        }
        String str = sc.next();
        int count = 1;
        boolean isAv = false;
 
        for(int i=1; i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
                    if(count>=7) {
                        isAv = true;
                        break;
                    }
            }
            else{
                count = 1;
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