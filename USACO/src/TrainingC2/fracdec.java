/*
ID: dennisl5
LANG: JAVA
TASK: fracdec
 */
package TrainingC2;

import java.util.*;
import java.io.*;
import java.text.*;

public class fracdec {
    static final String FILE = "fracdec";

    static String process(int n, int d) {
        int rem = n%d;
        StringBuilder res = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        while(rem != 0 && map.get(rem) == null) {
            map.put(rem, res.length());
            
            rem *= 10;
            res.append(rem/d);
            
            rem %= d;
        }
        return (rem == 0) ? "" : res.substring(0, map.get(rem))+" "+res.substring(map.get(rem));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(/*new InputStreamReader(System.in)*/new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        DecimalFormat df = new DecimalFormat("0.0");
        df.setMaximumFractionDigits(340);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
        String[] repeat = process(n, d).trim().split(" ");
        String ans;
        if(repeat[0].equals("")) ans = df.format((double)n/d);  //no repeat
        else ans = n/d+"." + ((repeat.length == 1) ? "("+repeat[0]+")" : repeat[0]+"("+repeat[1]+")");   //with repeat
        
        for(int i=0;i<ans.length();i+=76) out.println(ans.substring(i, Math.min(i+76, ans.length())));
    }
}