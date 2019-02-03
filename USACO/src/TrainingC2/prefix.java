/*
ID: dennisl5
LANG: JAVA
TASK: prefix
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class prefix {
    static final String FILE = "prefix";
    static int dp(String seq, List<String> prims) {
        int res = 0;
        boolean[] dpArr = new boolean[seq.length()+1];
        dpArr[0] = true;
        for(int i=1;i<dpArr.length;i++) {
            for(String tmp : prims) {
                int start = i+1-tmp.length(); //index at which tmp would start
                if(start > 0 && seq.substring(start-1, i).equals(tmp) && dpArr[start-1]) {
                    dpArr[i] = true;
                    res = Math.max(res, i);
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        StringTokenizer st;
        
        List<String> prims = new ArrayList<>();
        String tmp;
        while(!(tmp=br.readLine().trim()).equals(".")) {
            st = new StringTokenizer(tmp);
            while(st.hasMoreTokens()) {
                tmp = st.nextToken();
                prims.add(tmp);
            }
        }
        StringBuilder seq = new StringBuilder();
        while((tmp=br.readLine()) != null) seq.append(tmp.trim());
        
        out.println(dp(seq.toString(), prims));
    }
}
