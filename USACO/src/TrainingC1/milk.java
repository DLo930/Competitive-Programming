/*
ID: dennisl5
LANG: JAVA
TASK: milk
 */
package TrainingC1;

import java.util.*;
import java.io.*;



public class milk {
    static final String FILE = "milk";
    
    private static class Pair implements Comparator<Pair> {
        int i, j;
        public Pair() {}
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public int compare(Pair p1, Pair p2) { return p1.i - p2.i; }
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int lim = s.nextInt(), n = s.nextInt();
        Pair[] prices = new Pair[n];
        for(int i=0;i<n;i++) {
            prices[i] = new Pair(s.nextInt(),s.nextInt());
        }
        Arrays.sort(prices, new Pair());
        int res = 0;
        for(int i=0;i<n;i++) {
            if(lim == 0) break;
            
            int x = Math.min(prices[i].j, lim), price = prices[i].i;
            lim -= x;
            res += x*price;
        }
        out.println(res);
    }
}
