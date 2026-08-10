import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int[] arr = new int[n];
 
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int score  = arr[k-1];
 
        for(int j=0;j<n;j++){
            if(arr[j]>=score && arr[j]>0){
                count++;
            }
        }
        System.out.println(count);
    }
}