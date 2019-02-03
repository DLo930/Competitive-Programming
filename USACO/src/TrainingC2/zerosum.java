/*
ID: dennisl5
LANG: JAVA
TASK: zerosum
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class zerosum {
    static final String FILE = "zerosum";
    static int N;
    static List<String> arr;
    static boolean zerosum(int n) {
        int sum = 1;
        char prevOp = '+';
        for(int i=2;i<=N;i++) {
            if(prevOp == ' ' && n%3 == 0) return false;
            if(n%3 == 0) {
                sum = (prevOp == '+') ? sum-(i-1) : sum+(i-1);
                sum = (prevOp == '+') ? sum+10*(i-1)+i : sum-(10*(i-1)+i);
            }
            else if(n%3 == 1) sum += i;
            else sum -= i;
            prevOp = " +-".charAt(n%3);
            n /= 3;
        }
        return sum == 0;
    }
    static String toStr(int n) {
        StringBuilder sb = new StringBuilder("1");
        for(int i=2;i<=N;i++) {
            sb.append(" +-".charAt(n%3));
            n /= 3;
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(/*System.in*/new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        N = s.nextInt();
        arr = new ArrayList<>();
        for(int i=1;i<Math.pow(3,N-1);i++) if(zerosum(i)) arr.add(toStr(i));
        Collections.sort(arr);
        for(String str : arr) out.println(str);
    }
}
