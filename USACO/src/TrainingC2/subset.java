/*
ID: dennisl5
LANG: JAVA
TASK: subset
 */
//package TrainingC2;

import java.util.*;
import java.io.*;

public class subset {
    static final String FILE = "subset";
    static long[][] dp = new long[400][40];
    static long recur(int n, int curr) { //top-down DP
        if(n < 0 || curr < 0) return 0;
        if(dp[n][curr] >= 0) return dp[n][curr]; //if both curr and n are 0, current combination is valid
        return (dp[n][curr] = recur(n, curr-1)+recur(n-curr, curr-1));
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(/*System.in*/new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        dp[0][0] = 1;
        int n = s.nextInt(), m = n*(n+1);
        out.println(m%4 != 0 ? "0" : recur(m/4, n)/2);
    }
}
