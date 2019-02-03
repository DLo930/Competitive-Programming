/*
ID: dennisl5
LANG: JAVA
TASK: agrinet
 */
package TrainingC3;

import java.util.*;
import java.io.*;

public class agrinet {
    static final String FILE = "agrinet";
    static int n;
    
    static int prim(int[][] adjMat) {
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        
        visited.add(0);
        for(int i=0;i<n-1;i++) {    //loop n-1 times
            int minEdge = 100001, minNode = -1;
            for(Integer node : visited) {
                for(int j=0;j<n;j++)
                    if(!visited.contains(j) && j != node && adjMat[node][j] < minEdge) {
                        minEdge = adjMat[node][j];
                        minNode = j;
                    }
            }
            visited.add(minNode);
            res += minEdge;
        }
        return res;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        n = sc.nextInt();
        int[][] adjMat = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) adjMat[i][j] = sc.nextInt();
        }
        out.println(prim(adjMat));  //ANS: 28
    }
    static int pi(String s) { return Integer.parseInt(s); }
}
