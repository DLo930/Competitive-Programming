/*
ID: dennisl5
LANG: JAVA
TASK: sprime
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class sprime {
    static final String FILE = "sprime";
    static PrintWriter out;
    static boolean prime(int n) {
        if(n%2 == 0) return false;
        for(int i=3;i*i<=n;i+=2) if(n%i == 0) return false;
        return true;
    }
    static void superprimes(int places) {
         int[] primes = {2, 3, 5, 7};
         for(int i=0;i<4;i++) loop(places-1, primes[i]);
   }
    static void loop(int times, int curr) {
        if(times == 0) { //handles test case n=1
            out.println(curr);
            return;
        }
        int tmp = 0;
        for(int i=1;i<10;i+=2) {
            tmp = 10*curr+i;
            if(prime(tmp)) {
                if(times == 1) out.println(tmp);
                else loop(times-1, tmp);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        superprimes(s.nextInt());
    }
}
