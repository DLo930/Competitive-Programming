/*
ID: dennisl5
LANG: JAVA
TASK: lamps
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class lamps {
    static final String FILE = "lamps";
    static int n, c;
    static List<Integer> on, off;
    static Set<String> ans;
    static String combo(int i) {
        int tmp = Integer.bitCount(i);
        if(tmp > c) return null;
        char[] arr = new char[n];
        Arrays.fill(arr, '1');
        
        if((i&1) == 1) for(int j=0;j<n;j+=3) arr[j] = (arr[j]=='0') ? '1' : '0';
        i >>= 1;
        if((i&1) == 1) for(int j=1;j<n;j+=2) arr[j] = (arr[j]=='0') ? '1' : '0';
        i >>= 1;
        if((i&1) == 1) for(int j=0;j<n;j+=2) arr[j] = (arr[j]=='0') ? '1' : '0';
        i >>= 1;
        if((i&1) == 1) for(int j=0;j<n;j++) arr[j] = (arr[j]=='0') ? '1' : '0';
        i >>= 1;
        
        for(Integer x : on) if(arr[x-1] == '0') return null;
        for(Integer x : off) if(arr[x-1] == '1') return null;
        return new String(arr);
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        n = s.nextInt();
        c = s.nextInt();
        if(c > 4) c = (c%4 == 0) ? 4 : c%4;
        on = new ArrayList<>();
        off = new ArrayList<>();
        while(true) {
            int tmp = s.nextInt();
            if(tmp == -1) break;
            on.add(tmp);
        }
        while(true) {
            int tmp = s.nextInt();
            if(tmp == -1) break;
            off.add(tmp);
        }
        
        ans = new TreeSet<>();
        for(int i=0;i<16;i++) {
            String combo = combo(i);
            if(combo != null) ans.add(combo);
        }
        if(ans.isEmpty()) out.println("IMPOSSIBLE");
        for(String str : ans) out.println(str);
    }
}
