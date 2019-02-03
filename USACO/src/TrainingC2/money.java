/*
ID: dennisl5
LANG: JAVA
TASK: money
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class money {
    static final String FILE = "money";
    static PrintWriter out;
    static long[][] dp;
    static int[] coins;
    static long dp(int n, int curr) { //curr-index of coin to include
        if(n < 0 || curr == 0) return 0; //no more coins-invalid coin combination
        if(n == 0) return 1; //reaching 0 means valid coin combination
        if(dp[curr][n] != 0) return dp[curr][n];
        return (dp[curr][n] = dp(n-coins[curr], curr) + dp(n, curr-1));
    }
    static void printdp() {
        for(long[] arr : dp) {
            for(Long l : arr) out.print(l+" ");
            out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int v = s.nextInt(), n = s.nextInt();
        coins = new int[v+1];
        for(int i=1;i<=v;i++) coins[i] = s.nextInt();
        dp = new long[v+1][n+1];
        
        out.println(dp(n, v));
    }
}
