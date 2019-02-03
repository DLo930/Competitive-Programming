/*
ID: dennisl5
LANG: JAVA
TASK: nocows
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class nocows {
    static final String FILE = "nocows";
    static final int mod = 9901;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(/*System.in*/new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int N = s.nextInt(), K = s.nextInt();
        int[][] dpArr = new int[K+1][N+1];
        for(int k=1;k<=K;k++) {
            dpArr[k][1] = 1;
            for(int n=1;n<=N;n+=2) for(int i=1;i<=n-2;i++)
                dpArr[k][n] = (dpArr[k][n]+dpArr[k-1][i]*dpArr[k-1][n-i-1])%mod;
        }
        out.println((dpArr[K][N]-dpArr[K-1][N]+mod)%mod);
    }
}
