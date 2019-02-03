/*
ID: dennisl5
LANG: JAVA
TASK: pprime
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class pprime {
    static final String FILE = "pprime";
    static PrintWriter out;
    static boolean prime(int n) {
        if(n%2 == 0) return false;
        for(int i=3;i*i<=n;i+=2) if(n%i == 0) return false;
        return true;
    }
    static void getPalins(int a, int b) {
        for(int i=a;i<10 && i <=b;i++) if(prime(i)) out.println(i); //primes.add(i);
        
        int i = 1;
        while(true) {
            StringBuffer reverse = new StringBuffer(""+i).reverse();
            for(String digit : ",0,1,2,3,4,5,6,7,8,9".split(",")) {
                int tmp = Integer.parseInt(""+i+digit+reverse);
                if(tmp >= a) {
                    if(tmp <= b && prime(tmp)) out.println(tmp);
                    else if(tmp > b) return;
                }
            }
            i++;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        getPalins(s.nextInt(), s.nextInt());
    }
}
