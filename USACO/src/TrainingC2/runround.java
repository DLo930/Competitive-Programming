/*
ID: dennisl5
LANG: JAVA
TASK: runround
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class runround {
    static final String FILE = "runround";
    static boolean isUnique(int n) {
        boolean[] tmp = new boolean[10];
        while(n > 0) {
            if(tmp[n%10]) return false;
            tmp[n%10] = true;
            n /= 10;
        }
        return true;
    }
    static boolean runaround(int n) {
        int len = (""+n).length();
        int[] arr = new int[len];
        for(int i=len-1;i>=0;i--) {
            arr[i] = n % 10;
            n /= 10;
        }
        int curr = 0, newPos = 0;
        boolean[] tmp = new boolean[len];
        while(curr<len) {
            newPos = (newPos + arr[newPos]) % len;
            if(tmp[newPos]) return false;
            tmp[newPos] = true;
            curr++;
        }
        for(int i=0;i<len;i++) if(!tmp[i]) return false; //if any pos was unvisited
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(/*System.in*/new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt()+1;
        while(!isUnique(n) || !runaround(n)) n++;
        out.println(n);
    }
}
// I: 81361
// O: 81362

// I: 111110
// O: 134259