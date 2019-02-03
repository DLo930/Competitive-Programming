/*
ID: dennisl5
LANG: JAVA
TASK: beads
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class beads {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")), true);
        
        int n = s.nextInt();
        String str = s.next();
        str += str;
        char[] beads = str.toCharArray();
        
        int i = 0, sum1 = 0, sum2 = 0, w_combo = 0, res = 0;
        boolean w_walk = false;
        for (; i < 2*n; i++) {
            if (beads[i] == 'r' || beads[i] == 'b') {
                sum2 = 1;
                i++;
                break;
            }
            sum2 = n;
        }
        for (; i < 2*n; i++) {
            if (beads[i] == 'w') {
                w_walk = true;
                w_combo = 1;
                sum2++;
                beads[i] = beads[i - 1];
            }
            else if (beads[i] == beads[i - 1]) sum2++;
            else {
                res = Math.max(res, sum1 + sum2);
                sum1 = sum2;
                sum2 = 1;
                if (w_walk) {
                    sum2 += w_combo;
                    sum1 -= w_combo;
                }
                w_walk = false;
                w_combo = 0;
            }
        }
        res = Math.max(res, sum1 + sum2);
        res = Math.min(n, res);
        
        out.println(res);
    }
}