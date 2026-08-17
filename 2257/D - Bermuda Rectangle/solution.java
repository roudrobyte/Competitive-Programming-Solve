import java.io.*;
import java.util.*;
 
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
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
 
    static int lowerBound(long[] a, long x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
 
    static long solve(long s, long x, long y, long[] divisors, long[] prefix) {
        int pos = lowerBound(divisors, x + 1);
 
        long ans = 0;
        long limit = s / y;
 
        int p = lowerBound(divisors, limit + 1);
        int end = Math.min(pos, p);
 
        if (end > 0) {
            ans += divisors[end - 1] * y; 
        }
 
        if (pos > end) {
            ans += prefix[pos] - prefix[end];
        }
 
        long prev = pos == 0 ? 0 : divisors[pos - 1];
        if (prev < x && pos < divisors.length) {
            long d = divisors[pos];
            ans += (x - prev) * Math.min(y, s / d);
        }
 
        return ans;
    }
 
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
        String tStr = fs.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);
 
        while (t-- > 0) {
            long s = fs.nextLong();
            int q = fs.nextInt();
 
            ArrayList<Long> list = new ArrayList<>();
 
            for (long i = 1; i * i <= s; i++) {
                if (s % i == 0) {
                    list.add(i);
                    if (i * i != s) {
                        list.add(s / i);
                    }
                }
            }
 
            Collections.sort(list);
            
            int n = list.size();
            long[] divisors = new long[n];
            long[] prefix = new long[n + 1];
 
            for (int i = 0; i < n; i++) {
                divisors[i] = list.get(i);
                
                long previous = i == 0 ? 0 : divisors[i - 1];
                long height = s / divisors[i];
                prefix[i + 1] = prefix[i] + (divisors[i] - previous) * height;
            }
 
            while (q-- > 0) {
                long x = fs.nextLong();
                long y = fs.nextLong();
 
                out.println(solve(s, x, y, divisors, prefix));
            }
        }
 
        out.flush();
    }
}