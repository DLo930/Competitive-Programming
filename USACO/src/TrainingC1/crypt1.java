/*
ID: dennisl5
LANG: JAVA
TASK: crypt1
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class crypt1 {
    static final String FILE = "crypt1";
    static Set<Integer> set = new HashSet<>();
    
    static boolean check(int n) {
        while(n > 0) {
            if(set.contains(n%10)) n /= 10;
            else return false;
        }
        return true;
    }
    
    static boolean check2(int n) {
        int cnt = 0;
        while(n > 0) {
            if(set.contains(n%10)) {
                n /= 10;
                cnt++;
            }
            else return false;
        }
        return (cnt == 3);
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt(), res = 0;
        while(n-->0) set.add(s.nextInt());
        
        for(int i=100;i<=999;i++) {
            if(check(i)) for(int j=10;j<=99;j++) {
                if(check(j) && check2(i*(j%10)) && check2(i*(j/10)) && check(i*j)) {
                    //out.println(" "+i+"\n* "+j+"\n____\n "+i*(j%10)+"\n"+i*(j/10)+"\n____\n"+i*j+"\n");
                    res++;
                }
            }
        }
        out.println(res);
    }
}
