/*
ID: dennisl5
LANG: JAVA
TASK: milk3
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class milk3 {
    static final String FILE = "milk3";
    static boolean[][][] visited;
    static List<Integer> list;
    static int ac, bc, cc;
    static void recur(int a, int b, int c) {
        if(visited[a][b][c]) return;
        visited[a][b][c] = true;
        if(a == 0) list.add(c);
        
        int[] m = new int[6];
        m[0] = Math.min(bc-b, c);
        m[1] = Math.min(b, cc-c);
        m[2] = Math.min(ac-a, c);
        m[3] = Math.min(a, cc-c);
        m[4] = Math.min(ac-a, b);
        m[5] = Math.min(a, bc-b);
        
        recur(a, b+m[0], c-m[0]);
        recur(a, b-m[1], c+m[1]);
        recur(a+m[2], b, c-m[2]);
        recur(a-m[3], b, c+m[3]);
        recur(a+m[4], b-m[4], c);
        recur(a-m[5], b+m[5], c);
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        ac = s.nextInt();
        bc = s.nextInt();
        cc = s.nextInt();
        visited = new boolean[ac+1][bc+1][cc+1];
        list = new ArrayList<>();
        recur(0, 0, cc);
        Collections.sort(list);
        for(int i=0;i<list.size();i++) out.print(i != list.size()-1 ? (list.get(i)+" ") : list.get(i));
        out.println();
    }
}
