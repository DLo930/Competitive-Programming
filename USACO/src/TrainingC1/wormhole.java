/*
ID: dennisl5
LANG: JAVA
TASK: wormhole
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class wormhole {
    static final String FILE = "wormhole";
    static int n;
    static int[] x, y, pair, nextX;
    
    static boolean hasCycle() {
        for(int i=1;i<=n;i++) {
            int curr = i;
            for(int j=0;j<n;j++) curr = nextX[pair[curr]];
            if(curr > 0) return true;
        }
        return false;
    }
    
    static int solve() {
        // find first unpaired wormhole
        int i, total = 0;
        for (i = 1; i <= n; i++) if(pair[i] == 0) break; //stop when reach unpaired hole

        if (i == n+1) return hasCycle() ? 1 : 0;

        for (int j = i + 1; j <= n; j++) {
            if(pair[j] == 0) { //if both i and j unpaired
                pair[i] = j;
                pair[j] = i;
                total += solve();
                pair[i] = pair[j] = 0;
            }
        }
        return total;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        n = s.nextInt();
        
        x = new int[n+1];
        y = new int[n+1];
        for(int i=1;i<=n;i++) { //input x y
            x[i] = s.nextInt();
            y[i] = s.nextInt();
        }
        
        nextX = new int[n+1]; //initialize arr for nearest hole to the right, in the same row
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                if(i != j && x[i] < x[j] && y[i] == y[j])
                    if(nextX[i] == 0 || x[j]-x[i] < x[nextX[i]]-x[i])
                        nextX[i] = j;
        
        pair = new int[n+1];
        out.println(solve());
    }
}
