/*
ID: dennisl5
LANG: JAVA
TASK: barn1
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class barn1 {
    static final String FILE = "barn1";
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int M = s.nextInt()-1, S = s.nextInt(), C = s.nextInt();
        int[] cows = new int[C];
        for(int i=0;i<C;i++) cows[i] = s.nextInt();
        Arrays.sort(cows);
        
        List<Integer> gaps = new ArrayList<>();
        for(int i=1;i<C;i++) if(cows[i]-cows[i-1] > 1) gaps.add(cows[i]-cows[i-1]-1);
        Collections.sort(gaps, Collections.reverseOrder());
        
        int res = cows[C-1]-cows[0]+1, idx = 0;
        while(M > 0 && idx < gaps.size()) {
            res -= gaps.get(idx);
            idx++;
            M--;
        }
        out.println(res);
    }
}
