/*
ID: dennisl5
LANG: JAVA
TASK: numtri
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class numtri {
    static final String FILE = "numtri";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];
        for(int i=0;i<n;i++) {
            arr[i] = new int[i+1];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=n-2;i>=0;i--) for(int j=0;j<=i;j++) arr[i][j] += Math.max(arr[i+1][j],arr[i+1][j+1]);
        out.println(arr[0][0]);
    }
}
