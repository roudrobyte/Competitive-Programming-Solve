import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
    }
 
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String tStr = sc.next();
        if (tStr == null) return;
        
        int t = Integer.parseInt(tStr);
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            List<Integer>[] children = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                children[i] = new ArrayList<>();
            }
            
            for (int i = 2; i <= n; i++) {
                int p = sc.nextInt();
                children[p].add(i);
            }
            
            int m = sc.nextInt();
            boolean[] isDest = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                isDest[sc.nextInt()] = true;
            }
            
            boolean[] hasDestInSubtree = new boolean[n + 1];
            List<Integer> cameras = new ArrayList<>();
            
            dfs(1, children, isDest, hasDestInSubtree, cameras);
            
            // Format fix: Everything prints on a single line per test case 
            out.append(cameras.size());
            if (!cameras.isEmpty()) {
                out.append(" ");
                for (int i = 0; i < cameras.size(); i++) {
                    out.append(cameras.get(i)).append(i == cameras.size() - 1 ? "" : " ");
                }
            }
            out.append("
");
        }
        System.out.print(out.toString());
    }
    
    private static void dfs(int u, List<Integer>[] children, boolean[] isDest, boolean[] hasDestInSubtree, List<Integer> cameras) {
        hasDestInSubtree[u] = isDest[u];
        List<Integer> activeChildren = new ArrayList<>();
        
        for (int v : children[u]) {
            dfs(v, children, isDest, hasDestInSubtree, cameras);
            if (hasDestInSubtree[v]) {
                hasDestInSubtree[u] = true;
                activeChildren.add(v);
            }
        }
        
        if (isDest[u]) {
            cameras.addAll(activeChildren);
        } else {
            if (!activeChildren.isEmpty()) {
                for (int i = 0; i < activeChildren.size() - 1; i++) {
                    cameras.add(activeChildren.get(i));
                }
            }
        }
    }
}