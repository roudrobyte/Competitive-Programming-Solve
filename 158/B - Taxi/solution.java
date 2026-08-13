import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        int taxi = 0;
        int left = 0;
        int right = n-1;
 
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
 
        while(left<=right){
            int avSeat = 4- arr[right];
            taxi++;
            right--;
 
            while(left<=right && arr[left]<=avSeat){
                avSeat-=arr[left];
                left++;
            }
        }
        System.out.println(taxi);
    }
}