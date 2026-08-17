import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
 
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String tStr = sc.next();
        if (tStr == null) return;
        
        int t = Integer.parseInt(tStr);
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            
            long[] b = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextLong();
            }
            
            long ha = a[0], hb = b[0];
            int i = 0, j = 0;
            int turn = 0;
            
            while (true) {
                long ca = (i + 1 < n) ? (a[i + 1] - 1) : 0;
                long cb = (j + 1 < m) ? (b[j + 1] - 1) : 0;
                
                long da = Math.max(0L, ha - ca);
                long db = Math.max(0L, hb - cb);
                
                if (turn == 0) {
                    long tb = da + 1;
                    long tv = db; 
                    
                    if (tb <= tv) {
                        hb -= tb;
                        ha -= (tb - 1);
                        i++;
                        if (i == n) {
                            out.append("2
");
                            break;
                        }
                        ha = a[i];
                        turn = 1;
                    } else {
                        hb -= tv;
                        ha -= tv;
                        j++;
                        if (j == m) {
                            out.append("1
");
                            break;
                        }
                        hb = b[j];
                        turn = 0;
                    }
                } else {
                    long tv = db + 1;
                    long tb = da; 
                    
                    if (tv <= tb) {
                        ha -= tv;
                        hb -= (tv - 1);
                        j++;
                        if (j == m) {
                            out.append("1
");
                            break;
                        }
                        hb = b[j];
                        turn = 0;
                    } else {
                        ha -= tb;
                        hb -= tb;
                        i++;
                        if (i == n) {
                            out.append("2
");
                            break;
                        }
                        ha = a[i];
                        turn = 1;
                    }
                }
            }
        }
        System.out.print(out.toString());
    }
}