/*
ID: dennisl5
LANG: JAVA
TASK: frac1
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class frac1 {
    static final String FILE = "frac1";
    static class Fraction implements Comparator<Fraction> {
        int a, b;
        public Fraction() {}
        public Fraction(int a, int b) {
            int gcd = gcd(a,b);
            this.a = a/gcd;
            this.b = b/gcd;
        }
        double doubleValue() { return (double)a/b; }
        @Override
        public int compare(Fraction a, Fraction b) { return (a.doubleValue()>b.doubleValue()) ? 1 : -1; }
        @Override
        public String toString() { return a+"/"+b; }
    }
    static int gcd(int a, int b) { return (b == 0) ? a : gcd(b, a%b); }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt();
        Set<Double> set = new HashSet<>();
        Set<Fraction> fracs = new TreeSet<>(new Fraction());
        fracs.add(new Fraction(0,1));
        fracs.add(new Fraction(1,1));
        for(int i=1;i<=n;i++) { //denominator
            for(int j=1;j<i;j++) {//numerator
                if(set.contains((double)j/i)) continue;
                fracs.add(new Fraction(j,i));
                set.add((double)j/i);
            }
        }
        for(Fraction f : fracs) out.println(f);
    }
}
