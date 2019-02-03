package TrainingC1;

/*
ID: dennisl5
LANG: JAVA
TASK: milk2
 */
//package Training;
import java.util.*;
import java.io.*;

public class milk2 {
    private static class Pair implements Comparator<Pair> {
        int i, j;
        public Pair() {}
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public int compare(Pair p1, Pair p2) {
            return (p1.i != p2.i) ? p1.i-p2.i : p1.j-p2.j;
        }
    }
    static final String FILE = "milk2";
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt();
        Pair[] pairs = new Pair[n];
        for(int i=0;i<n;i++) pairs[i] = new Pair(s.nextInt(), s.nextInt());
        Arrays.sort(pairs, new Pair());
        
        int i = 1, r = pairs[0].j, tmpMax = pairs[0].j-pairs[0].i, res1 = tmpMax, res2 = 0;
        for(;i<n;i++) {
            if(r >= pairs[i].i && r < pairs[i].j) { //if overlap
                tmpMax += pairs[i].j-r;
                r = pairs[i].j;
            }
            else if(r < pairs[i].i) {
                res1 = Math.max(res1, tmpMax);
                tmpMax = pairs[i].j-pairs[i].i;
                res2 = Math.max(res2, pairs[i].i-r);
                r = pairs[i].j;
            }
        }
        out.println(res1+" "+res2);
    }
}