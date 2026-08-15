import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
 
        int sum = s;
        boolean isDef = false;
 
        int[] x = new int[n];
        int[] y = new int[n];
 
        for(int i=0; i<n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
 
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1;j++){
                if(x[j]>x[j+1]){
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
 
                    int temp1 = y[j];
                    y[j] = y[j+1];
                    y[j+1] = temp1;
                }
            }
        }
 
        for(int i=0; i<n; i++){
            if(x[i]>=sum){
                isDef = true;
                break;
            }
            sum+=y[i];
        }
 
        if(!isDef){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}