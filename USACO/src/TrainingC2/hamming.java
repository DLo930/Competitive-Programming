/*
ID: dennisl5
LANG: JAVA
TASK: hamming
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class hamming {
    static final String FILE = "hamming";
    static int hdist(int a, int b) { return Integer.bitCount(a^b); }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt(), b = 1 << s.nextInt(), d = s.nextInt(), curr = 1;
        List<Integer> arr = new ArrayList<>();
        arr.add(curr-1);
        while(curr < b && arr.size() < n) {
            boolean flag = true;
            for(Integer i : arr) if(hdist(i, curr) < d) {
                flag = false;
                break;
            }
            if(flag) arr.add(curr);
            curr++;
        }
        for(int i=0;i<arr.size()-1;i++) out.print(arr.get(i)+((i%10==9) ? "\n" : " "));
        out.println(arr.get(arr.size()-1));
    }
}
