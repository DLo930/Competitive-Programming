/*
ID: dennisl5
LANG: JAVA
TASK: skidesign
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class skidesign {
    static final String FILE = "skidesign";
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt(), res = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        
        for(int i=0;i<=100;i++) {
            int tmp = 0;
            for(int j=0;j<n;j++) {
                int diff = arr[j]-i;
                if(diff > 17) {
                    diff -= 17;
                    tmp += diff*diff;
                }
                else if(diff < 0) tmp += diff*diff;
            }
            res = Math.min(res, tmp);
        }
        out.println(res);
    }
}
