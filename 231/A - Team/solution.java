import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int a = sc.nextInt();
        int[] arr = new int[3];
        for(int i=0;i<a;i++){
            for(int j=0;j<3;j++){
                arr[j] = sc.nextInt();
            }
            int count1 = 0;
 
            for(int k=0;k<3;k++){
                if(arr[k] == 1){
                    count1++;
                }
            }
            if(count1>1){
                total++;
            }
        }
        System.out.println(total);
    }
}