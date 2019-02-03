/*
ID: dennisl5
LANG: JAVA
TASK: inflate
 */
//package TrainingC3;

import java.util.*;
import java.io.*;

public class inflate {
    static final String FILE = "inflate";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(/*new InputStreamReader(System.in)*/new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = pi(st.nextToken()), n = pi(st.nextToken());
        int[] dp = new int[m+1];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int pts = pi(st.nextToken()), min = pi(st.nextToken());
            for(int j=min;j<=m;j++) dp[j] = Math.max(dp[j], dp[j-min]+pts);
        }
        out.println(dp[m]);
    }
    static int pi(String s) { return Integer.parseInt(s); }
}
