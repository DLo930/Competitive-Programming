/*
ID: dennisl5
LANG: JAVA
TASK: palsquare
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class palsquare {
    static final String FILE = "palsquare";
    static final char[] digs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
    
    static boolean isPalin(String s) {
        int n = s.length();
        for(int i=0;i<n/2;i++) if(s.charAt(i) != s.charAt(n-1-i)) return false;
        return true;
    }
    
    static String changeBase(int n, int b) {
        StringBuilder sb = new StringBuilder();
        int i = n;
        while(i >= b) {
            sb.insert(0, digs[i%b]);
            i /= b;
        }
        return sb.insert(0, digs[i]).toString();
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int b = s.nextInt();
        for(int i=1;i<=300;i++) {
            String str = changeBase(i*i, b);
            if(isPalin(str)) out.println(changeBase(i,b)+" "+str);
        }
    }
}
