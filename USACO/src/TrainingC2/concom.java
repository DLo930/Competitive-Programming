/*
ID: dennisl5
LANG: JAVA
TASK: concom
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class concom {
    static final String FILE = "concom";
    static int N = 100;
    static int[][] dp;
    static int[] c;
    static boolean[] v;
    static void dfs(int n) {
        v[n] = true;
        for(int i=1;i<=N;i++) c[i] += dp[n][i];
        for(int i=1;i<=N;i++) if(c[i] > 50 && !v[i] && i != n)
            dfs(i);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine().trim());
        
        dp = new int[101][101];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            dp[a][b] = c;
        }
        
        c = new int[101];
        v = new boolean[101];
        for(int i=1;i<=N;i++) {
            Arrays.fill(c, 0);
            Arrays.fill(v, false);
            dfs(i);
            for(int j=1;j<=N;j++) if(c[j] > 50 && i != j)
                out.println(i+" "+j);
        }
    }
}
