/*
ID: dennisl5
LANG: JAVA
TASK: combo
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class combo {
    static final String FILE = "combo";
    
    static int overlap(int n, int a, int b) {
        if(a == b) return 5;
        if(a > b) { //swap if not in order
            a += b;
            b = a-b;
            a -= b;
        }
        int res = 0;
        if(a+2 >= b-2) res += (a+2)-(b-2)+1;
        if((b+2)%n >= a-2 && (b+2)%n <= a+2) res += (b+2)%n-(a-2)+1;
        return res;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt();
        int[][] arr = new int[2][3];
        for(int i=0;i<6;i++) arr[i/3][i%3] = s.nextInt();
        int[] overlaps = new int[3];
        for(int i=0;i<3;i++) overlaps[i] = overlap(n, arr[0][i], arr[1][i]);
        //for(Integer i : overlaps) out.println(i);
        
        out.println((n > 5) ? 250-overlaps[0]*overlaps[1]*overlaps[2] : n*n*n);
    }
}
