/*
ID: dennisl5
LANG: JAVA
TASK: holstein
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class holstein {
    static final String FILE = "holstein";
    static int[] vitamins;
    static int[][] feed;
    static int v, g;
    static boolean noPos(int[] arr) {
        for(int i=0;i<arr.length;i++) if(arr[i] > 0) return false;
        return true;
    }
    static int[] subtract(int[] arr1, int[] arr2) {
        int[] tmp = new int[arr1.length];
        for(int i=0;i<arr1.length;i++) tmp[i] = arr1[i]-arr2[i];
        return tmp;
    }
    static String convert(int n) {
        StringBuilder sb = new StringBuilder();
        char[] tmp = Integer.toBinaryString(n).toCharArray();
        for(int i=1;i<=tmp.length;i++) if(tmp[tmp.length-i] == '1') sb.append(i+" ");
        return sb.toString().trim();
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        v = s.nextInt();
        vitamins = new int[v];
        for(int i=0;i<v;i++) vitamins[i] = s.nextInt();
        g = s.nextInt();
        feed = new int[g][v];
        for(int i=0;i<g;i++) for(int j=0;j<v;j++) feed[i][j] = s.nextInt();
        
        List<Integer> arr = new ArrayList<>();
        int min = Integer.MAX_VALUE, tmp, cnt, bits;
        int[] tmpArr;
        for(int i=0;i<(1<<g);i++) {
            tmp = i;
            cnt = 0;
            bits = Integer.bitCount(i);
            //out.println(i+" "+bits);
            tmpArr = vitamins;
            while(tmp > 0) {
                if((tmp & 1) == 1) tmpArr = subtract(tmpArr, feed[cnt]);
                tmp >>= 1;
                cnt++;
            }
            //for(int j=0;j<tmpArr.length;j++) out.print(tmpArr[j]+" ");
            //out.println();
            if(noPos(tmpArr)) {
                if(bits < min) {
                    min = bits;
                    arr.clear();
                    arr.add(i);
                }
                else if(bits == min) arr.add(i);
            }
            //out.println(min);
        }
        out.print(min+" ");
        out.println(convert(arr.get(0)));
    }
}
